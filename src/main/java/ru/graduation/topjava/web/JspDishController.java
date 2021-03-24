package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.graduation.topjava.service.DishService;

@Controller
public class JspDishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public String getMenu(Model model) {
        model.addAttribute("dishes", dishService.getAll());
        return "dishes";
    }

    @GetMapping("/dishes/edit")
    public String getEditMenu(Model model) {
        model.addAttribute("dishes", dishService.getAll());
        return "dishForm";
    }
}
