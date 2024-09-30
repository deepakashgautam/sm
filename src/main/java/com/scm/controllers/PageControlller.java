package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControlller {

    @RequestMapping("/home")
    public String home(Model model){
         //sending data to view using thymeleaf
         model.addAttribute("name","Substriong technology");
         model.addAttribute("youtube","https://www.youtube.com/");
         model.addAttribute("GitHub","https://www.github.com/");
         System.out.println("Hello-Home-Page");
         return "home";
    }


    @RequestMapping("/service")
    public String servicePage(Model model){
        System.out.println("Hello-Services-Page");
        return "service";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model){
        System.out.println("Hello-About-Page");
        return "about";
    }

    @RequestMapping("/contact")
    public String ContactPage(Model model){
        System.out.println("Hello-About-Page");
        return "contact";
    }

    @RequestMapping("/login")
    public String LoginPage(Model model){
        System.out.println("Hello-About-Page");
        return "login";
    }

    @RequestMapping("/register")
    public String RegisterPage(Model model){
        System.out.println("Hello-About-Page");
        return "register";
    }

    @GetMapping("/")
    public String handleBlankRequest(){
        return "ARREY OYE BLANK REQUEST HANDLED";
    }
}
