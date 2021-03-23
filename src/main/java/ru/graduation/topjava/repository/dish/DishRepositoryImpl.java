package ru.graduation.topjava.repository.dish;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.graduation.topjava.model.Dish;

import java.util.Date;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    private static final Sort SORT_DATE = Sort.by(Sort.Direction.DESC, "date");

    private final CrudDishRepository dishRepository;

    public DishRepositoryImpl(CrudDishRepository dishRepository) {
        this.dishRepository = dishRepository;
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
        return dishRepository.findAll(SORT_DATE);
    }
}
