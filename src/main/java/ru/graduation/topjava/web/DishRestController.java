package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.service.DishService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "rest/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAll() {
        return dishService.getAll();
    }

    @GetMapping("/menu/emptyList")
    public List<Dish> getDefaultMenu() {
        return new ArrayList<>();
    }

    @GetMapping("/menu/{id}")
    public List<Dish> getTodayMenu(@PathVariable int id) {
        return dishService.getRestaurantMenu(id, LocalDate.now());
    }
}
