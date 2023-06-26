package com.exercise.login__registration.services;

import com.exercise.login__registration.models.LoginUser;
import com.exercise.login__registration.models.User;
import com.exercise.login__registration.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User register(User newUser, BindingResult result){

        Optional<User> checkingUser = userRepository.findByEmail(newUser.getEmail());
        if(checkingUser.isPresent()){
            result.rejectValue("email", "InvalidEmail", "This email already exist");

        }

        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("password","InvalidPassword","Passwords do not match ");

        }

        if (result.hasErrors()){
            return null;
        }
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepository.save(newUser);
    }

    public User login(LoginUser newLogin, BindingResult result){

        Optional<User> checkingLoginUser = userRepository.findByEmail(newLogin.getEmail());
        if(!checkingLoginUser.isPresent()){
            result.rejectValue("email", "InvalidEmail", "Invalid Email");

        }
        User user  =checkingLoginUser.get();

        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
            result.rejectValue("password", "InvalidPassword","The password is not correct!");
        }

        return user;
        }


        public User findByEmail(String email){
       return userRepository.findByEmail(email).orElse(null);
        }
    public User findById(Long Id){
        return userRepository.findById(Id).orElse(null);
    }



}
