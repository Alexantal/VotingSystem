package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.repository.dish.DishRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.graduation.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create(Dish dish, int restId) {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish, restId);
    }

    public void update(Dish dish, int restId) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(dishRepository.save(dish, restId), dish.getId());
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

    public Dish get(int id) {
        return checkNotFoundWithId(dishRepository.get(id), id);
    }

    public List<Dish> getAll() {
        return dishRepository.getAll();
    }

    public List<Dish> getLastDateRestaurantMenu(int rest_id) {
        return dishRepository.getLastDateRestaurantMenu(rest_id);
    }

    public List<Dish> getRestaurantMenu(int rest_id, LocalDate date) {
        return dishRepository.getRestaurantMenu(rest_id, date);
    }
}
