package ru.graduation.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.service.DishService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "rest/admin/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService dishService;

    @PostMapping(value = "/{restId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrUpdate(Dish dish, @PathVariable int restId) {
        if (dish.isNew()) {
            log.info("create new dish for restaurant {}", restId);
            dishService.create(dish, restId);
        } else {
            log.info("update dish for restaurant {}", restId);
            dishService.update(dish, restId);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete dish with id = {}", id);
        dishService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Dish get(@PathVariable int id) {
        log.info("get dish with id = {}", id);
        return dishService.get(id);
    }

    @GetMapping("/emptyList")
    public List<Dish> getEmptyList() {
        return new ArrayList<>();
    }

    @GetMapping(value = "/lastMenu/{restId}")
    public List<Dish> getLastMenu(@PathVariable int restId) {
        return dishService.getLastDateRestaurantMenu(restId);
    }
}
