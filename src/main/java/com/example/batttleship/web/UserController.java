package com.example.batttleship.web;

import com.example.batttleship.models.biding.LoginBidingModel;
import com.example.batttleship.models.biding.RegisterBidingModel;
import com.example.batttleship.models.service.RegisterServiceModel;
import com.example.batttleship.models.service.UserServiceLoginModel;
import com.example.batttleship.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                          String username, RedirectAttributes attributes) {

            attributes.addFlashAttribute("bad_credentials", true);
            attributes.addFlashAttribute("username", username);

            return "redirect:login";

    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterBidingModel registerBidingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !registerBidingModel.getPassword()
                .equals(registerBidingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerBidingModel", registerBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerBidingModel");

            return "redirect:register";
        }
        userService.registerUser(modelMapper
                .map(registerBidingModel, RegisterServiceModel.class));
        return "redirect:login";
    }


    @ModelAttribute
    public RegisterBidingModel registerBidingModel() {
        return new RegisterBidingModel();
    }
}
