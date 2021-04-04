package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import ru.graduation.topjava.model.Restaurant;
import ru.graduation.topjava.repository.restaurant.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restRepository;

    public RestaurantService(RestaurantRepository restRepository) {
        this.restRepository = restRepository;
    }

    public List<Restaurant> getAll() {
        return restRepository.getAll();
    }
}
