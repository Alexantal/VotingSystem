package ru.graduation.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.graduation.topjava.service.DishService;
import ru.graduation.topjava.service.UserService;
import ru.graduation.topjava.service.VoteService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return userService.isAdmin(userId) ? "redirect:dishes/edit" : "redirect:/menu";
    }

    @GetMapping("/votes")
    public String getVotes(Model model) {
        model.addAttribute("votes", voteService.getAll());
        return "votes";
    }
}
