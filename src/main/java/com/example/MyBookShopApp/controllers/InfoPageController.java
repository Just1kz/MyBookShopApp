package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoPageController {

    @GetMapping("/company")
    public String company() {
        return "/mapping/info/company/company";
    }

    @GetMapping("/documents")
    public String documents() {
        return "/mapping/info/documents/documents";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "/mapping/info/contacts/contacts";
    }

    @GetMapping("/help")
    public String help() {
        return "/mapping/info/help/help";
    }
}
