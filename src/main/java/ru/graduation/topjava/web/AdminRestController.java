package ru.graduation.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.graduation.topjava.model.Restaurant;
import ru.graduation.topjava.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "rest/admin/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restService;

    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get {}", id);
        return restService.get(id);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAll");
        return restService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrUpdate(Restaurant restaurant) {
        if (restaurant.isNew()) {
            log.info("create new restaurant");
            restService.create(restaurant);
        } else {
            log.info("update {}", restaurant);
            restService.update(restaurant);
        }
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enable(@PathVariable int id, @RequestParam boolean enabled) {
        log.info(enabled ? "enable {}" : "disable {}", id);
        restService.enable(id, enabled);
    }
}
