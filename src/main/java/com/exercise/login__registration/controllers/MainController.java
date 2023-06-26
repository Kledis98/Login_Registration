package com.exercise.login__registration.controllers;

import com.exercise.login__registration.models.LoginUser;
import com.exercise.login__registration.models.User;
import com.exercise.login__registration.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("userId") != null) {
            return "redirect:/welcome";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index";

    }

    @PostMapping("/register")

    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
                           HttpSession session) {

        User user = userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }

        session.setAttribute("userId", user.getId());

        return "redirect:/welcome";
    }


    @PostMapping("/login")

    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
                        HttpSession session) {

        User user = userService.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        }

        session.setAttribute("userId", user.getId());

        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        User loggedInUser = userService.findById(userId);

        model.addAttribute("user", loggedInUser);

        return "welcome";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
