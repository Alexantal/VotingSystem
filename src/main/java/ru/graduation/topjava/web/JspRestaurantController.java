package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.graduation.topjava.service.RestaurantService;

@Controller
public class JspRestaurantController {

    @Autowired
    private RestaurantService restService;

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("restaurants", restService.getAll());
        return "votingForm";
    }
}
