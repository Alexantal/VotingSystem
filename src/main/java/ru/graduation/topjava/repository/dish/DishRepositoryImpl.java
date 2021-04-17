package ru.graduation.topjava.repository.dish;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.graduation.topjava.model.Dish;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    private static final Sort SORT_DATE = Sort.by(Sort.Direction.DESC, "date");

    private final CrudDishRepository crudDishRepository;

    public DishRepositoryImpl(CrudDishRepository crudDishRepository) {
        this.crudDishRepository = crudDishRepository;
    }

    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Dish get(int id) {
        return null;
    }

    @Override
    public List<Dish> getByDate(Date date) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return crudDishRepository.findAll(SORT_DATE);
    }

    @Override
    public List<Dish> getRestaurantMenu(int rest_id, LocalDate date) {
        return crudDishRepository.getRestaurantMenu(rest_id, date);
    }
}
