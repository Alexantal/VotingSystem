package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import ru.graduation.topjava.model.Role;
import ru.graduation.topjava.model.User;
import ru.graduation.topjava.repository.user.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public boolean isAdmin(int id) {
        return get(id).getRoles().contains(Role.ADMIN);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
