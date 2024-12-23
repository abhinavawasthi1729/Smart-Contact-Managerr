package com.scm.controllers;
import java.util.*;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){
        System.out.println("home page controller");
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("about page controller");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("services page controller");
        return "services";
    }

    @RequestMapping("/contact")
    public String contact(){
        System.out.println("contact page controller");
        return "contact";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("login page controller");
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model ){
        System.out.println("register page controller");
        UserForm userForm = new UserForm();
//        userForm.setName("abhinav");
//        userForm.setEmail("a@gmai.com");
        model.addAttribute("userForm", userForm);
        return "register";
    }


    //processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){
        System.out.println("do-register page controller");
//        System.out.println(userForm.getName());

//        User user= new User.Builder()
//                .setName(userForm.getName())
//                .setPassword(userForm.getPassword())
//                .setEmail(userForm.getEmail())
//                .setAbout(userForm.getAbout())
//                .setPhoneNumber(String.valueOf(userForm.getPhoneNumber()))
//                .setProfilePic("src/main/resources/static/images/userProfile.jpg")
//                .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setEmail(userForm.getEmail());
        user.setPhoneNumber(String.valueOf(userForm.getPhoneNumber()));
        user.setAbout(userForm.getAbout());
        user.setProfilePic("src/main/resources/static/images/userProfile.jpg");

        User saveUser =userService.saveUser(user);
        System.out.println("user saved");

        Message message = new Message.MessageBuilder()
                .setContent("Registration sucessful")
                .setType(MessageType.green)
                .build();
        session.setAttribute("message", message);
        return "redirect:/register";

    }
}
