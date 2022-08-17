package com.intializer.firstProject.controllers;

import com.intializer.firstProject.repositories.AuthorRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class authorController {
    private AuthorRepositories authorRepositories;

    public authorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepositories.findAll());

        return "authors/list";
    }
}
