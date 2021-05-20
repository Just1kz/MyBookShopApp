package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsPageController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsPageController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorMap() {
        return authorsService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorPage() {
        return "/mapping/authors/index";
    }
}
