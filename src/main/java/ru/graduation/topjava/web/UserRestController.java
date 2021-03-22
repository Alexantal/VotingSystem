package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.graduation.topjava.model.User;
import ru.graduation.topjava.service.UserService;

import java.util.List;

@Controller
public class UserRestController {

    @Autowired
    private UserService service;

    public List<User> getAll() {
        return service.getAll();
    }
}
