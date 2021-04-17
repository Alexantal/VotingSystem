package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.repository.dish.DishRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAll() {
        return dishRepository.getAll();
    }

    public List<Dish> getRestaurantMenu(int rest_id, LocalDate date) {
        return dishRepository.getRestaurantMenu(rest_id, date);
    }
}
