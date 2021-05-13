package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.graduation.topjava.model.Restaurant;
import ru.graduation.topjava.repository.restaurant.RestaurantRepository;

import java.util.List;

import static ru.graduation.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {
    private final RestaurantRepository restRepository;

    public RestaurantService(RestaurantRepository restRepository) {
        this.restRepository = restRepository;
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restRepository.get(id), id);
    }

    public List<Restaurant> getAll() {
        return restRepository.getAll();
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restRepository.save(restaurant);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(restRepository.save(restaurant), restaurant.getId());
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        Restaurant restaurant = get(id);
        restaurant.setEnabled(enabled);
        restRepository.save(restaurant);  // !! need only for JDBC implementation
    }
}
