package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import ru.graduation.topjava.model.Dish;
import ru.graduation.topjava.repository.dish.DishRepository;

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
}
