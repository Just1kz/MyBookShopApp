package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchPageController {

    private final BookService bookService;

    @Autowired
    public SearchPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
//        model.addAttribute("searchingObj", "");
        return "/mapping/search/search";
    }

    @PostMapping("/searching")
    public String searchBook(@RequestParam("query") String rsl, Model model) {
        if (bookService.findBookByTitle(rsl).size() >= 1) {
            model.addAttribute("searchByTitle", bookService.findBookByTitle(rsl));
        }
    if (bookService.findBookByAuthor(rsl).size() >= 1) {
        model.addAttribute("searchByAuthor", bookService.findBookByAuthor(rsl));
    }
        return "/mapping/search/search";
    }
}
