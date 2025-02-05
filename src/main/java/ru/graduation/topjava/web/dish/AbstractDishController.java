package ru.graduation.topjava.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.service.DishService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDishController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DishService dishService;

    public Dish create(Dish dish, int restId) {
        log.info("create new dish for restaurant {}", restId);
        return dishService.create(dish, restId);
    }

    public void update(Dish dish, int restId) {
        log.info("update dish for restaurant {}", restId);
        dishService.update(dish, restId);
    }

    public void delete(int id) {
        log.info("delete dish with id = {}", id);
        dishService.delete(id);
    }

    public Dish get(int id) {
        log.info("get dish with id = {}", id);
        return dishService.get(id);
    }

    public List<Dish> getEmptyList() {
        log.info("get empty list");
        return new ArrayList<>();
    }

    public List<Dish> getLastMenu(int restId) {
        return dishService.getLastDateRestaurantMenu(restId);
    }

    public List<Dish> getAll() {
        log.info("get All");
        return dishService.getAll();
    }

    /*public List<Dish> getDefaultMenu() {
        log.info("get empty list");
        return new ArrayList<>();
    }*/

    public List<Dish> getTodayMenu(int id) {
        log.info("get today's menu for restaurant {}", id);
        return dishService.getRestaurantMenu(id, LocalDate.now());
    }
}
