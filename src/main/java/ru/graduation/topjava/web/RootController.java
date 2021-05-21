package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.graduation.topjava.service.RestaurantService;
import ru.graduation.topjava.service.UserService;
import ru.graduation.topjava.service.VoteService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private RestaurantService restService;

    @GetMapping("/")
    public String root() {
        return "redirect:/user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String getMenu(Model model) {
        model.addAttribute("restaurants", restService.getAll());
        return "votingForm";
    }

    @GetMapping("/admin")
    public String adminForm() {
        return "restaurantForm";
    }
}
