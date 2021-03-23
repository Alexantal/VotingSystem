package ru.graduation.topjava.repository.dish;

import ru.graduation.topjava.model.Dish;

import java.util.Date;
import java.util.List;

public interface DishRepository {
    // null if not found, when updated
    Dish save(Dish dish);

    // false if not found
    boolean delete(int id);

    // null if not found
    Dish get(int id);

    // null if not found
    List<Dish> getByDate(Date date);

    List<Dish> getAll();
}
