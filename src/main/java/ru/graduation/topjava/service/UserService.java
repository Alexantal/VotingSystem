package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import ru.graduation.topjava.model.User;
import ru.graduation.topjava.repository.user.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
