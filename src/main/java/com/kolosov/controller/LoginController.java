package com.kolosov.controller;

import com.kolosov.exception.UserAlreadyExistException;
import com.kolosov.model.User;
import com.kolosov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        try {
            userService.registerNewUser(user);
        } catch (UserAlreadyExistException e) {
            bindingResult.addError(new FieldError("user", "email", "пользователь с таким email существует"));
            return "registration";
        }

        return "index";
    }
}
