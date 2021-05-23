package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Book;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SearchPageController {

    private final BookService bookService;

    @Autowired
    public SearchPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        return "/mapping/search/index";
    }

    @PostMapping("/searching")
    public String searchBook(@RequestParam(value = "query2") String rsl, Model model) {

        if (bookService.findBookByTitle(rsl).size() > 0) {
            model.addAttribute("searchByTitle", bookService.findBookByTitle(rsl));
        } else {
            model.addAttribute("searchByTitle", new ArrayList<Book>());
        }

        if (bookService.findBookByAuthor(rsl).size() > 0) {
            model.addAttribute("searchByAuthor", bookService.findBookByAuthor(rsl));
        } else {
            model.addAttribute("searchByAuthor", new ArrayList<Book>());
        }

        return "/mapping/search/index";
    }
}
