package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationPageController {

    @GetMapping("/authentication")
    public String authenticationPage() {
        return "/mapping/authentication/index";
    }
}
