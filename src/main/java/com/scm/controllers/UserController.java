package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard page
     @RequestMapping(value="/dashboard")
    public String userDashboard() {
     // TODO: Implement user dashboard logic
      return "user/dashboard";
     }

    //user profile page
    @RequestMapping(value="/profile")
    public String userProfile() {
        // TODO: Implement user dashboard logic
        return "user/profile";
    }

    // user add contact page

    // user edit contact page

    // user delete contact page

    // user search contact page

    // user view contact page

    // user logout page
}
