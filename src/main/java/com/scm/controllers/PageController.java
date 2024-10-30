package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/home")
    public String home(Model model){
         //sending data to view using thymeleaf
        model.addAttribute("name", "Substring Technology");
        model.addAttribute("youtube", "https://www.youtube.com/");
        model.addAttribute("GitHub", "https://www.github.com/");
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
        //System.out.println("Hello-About-Page");
        UserForm userForm = new UserForm();
        userForm.setName("deepAkash");
        userForm.setAbout("Enter something about this user...");
        model.addAttribute("userForm",userForm);
        return "register";
    }

    @RequestMapping("/")
    public String handleBlankRequest(Model model){
        return "home";
    }

    //process register request
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){

        //step-1. fetch form data
         //userForm
        System.out.println(userForm);
        //step-2. validate data
           //TODO:: validate name, password, email, about, phoneNumber
        //step-3. save data to database
        //UserService
           //UserForm-------------------------------->user
          User user=User.builder()
                  .name(userForm.getName())
                  .email(userForm.getEmail())
                  .about(userForm.getAbout())
                          .phoneNumber(userForm.getPhoneNumber())
                                  .phoneNumber(userForm.getPhoneNumber())
                  .password(userForm.getPassword())
                  .profilePic("https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&w=600").build();
        User saveUser = userService.saveUser(user);
        System.out.println("Saved User : "+saveUser);
        //step-4. message ="Registration successfully"
        return "redirect:/register";
    }
}
