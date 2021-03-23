package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.graduation.topjava.service.DishService;
import ru.graduation.topjava.service.UserService;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private DishService dishService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("dishes")
    public String getMenu(Model model) {
        model.addAttribute("dishes", dishService.getAll());
        return "dishes";
    }
}
