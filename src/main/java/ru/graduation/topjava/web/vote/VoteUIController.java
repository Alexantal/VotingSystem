package ru.graduation.topjava.web.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.graduation.topjava.model.Vote;
import ru.graduation.topjava.service.VoteService;

@RestController
@RequestMapping(value = "profile/votes")
public class VoteUIController {

    @Autowired
    private VoteService voteService;

    /*@PostMapping("/{restId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@PathVariable int restId) {
        Vote vote = new Vote()
        voteService.create(vote);
    }*/
}
