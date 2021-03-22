package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.graduation.topjava.service.UserService;

@Controller
public class RootController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String root() {
        return "index";
    }
}
