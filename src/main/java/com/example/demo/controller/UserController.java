package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute(name = "registeredUser") User user,
                               ModelMap modelMap) {
        User savedUser = userService.saveUser(user);
        if (savedUser == null) {
          modelMap.put("registerErrorMessage", "User with phone number = " + user.getPhone() + " already exists!");
            return "redirect:/home";
        } else {
//            redirectAttributes.addAttribute("phone", user.getPhone());
//            redirectAttributes.addAttribute("password", user.getPassword());
//            modelMap.addAttribute("phone",user.getPhone());
            user.setVerifyCode(null);
            user.setPassword(null);
            modelMap.addAttribute("verifiedUser", user);
            return "verify";
        }
    }



    @PostMapping("/verify")
    public String verifyPage(@ModelAttribute(name="verifiedUser")User user, ModelMap modelMap){
        User verified = userService.verifyAccount(user);
        if(verified!=null){
            modelMap.addAttribute("currentUser", verified);
            return  "successPage";
        }else {
            modelMap.addAttribute("verifiedUser", user);
            modelMap.addAttribute("errorMessage", "Invalid operation!");
            return "verify";
        }
    }


}
