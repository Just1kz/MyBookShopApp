package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class AuthorsPageController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsPageController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/authors")
    public String authorPage(Model model) {
        model.addAttribute("bAuthors", authorsService.getAuthorData("Б"));
        return "authors/index";
    }
}
