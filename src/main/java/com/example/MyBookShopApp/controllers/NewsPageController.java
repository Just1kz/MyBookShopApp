package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsPageController {

    @GetMapping("/news")
    public String newsPage() {
        return "/mapping/news/recent";
    }
}
