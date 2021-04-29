package ru.graduation.topjava.web.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.graduation.topjava.model.Vote;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController extends AbstractVoteController {
    public static final String REST_URL = "/rest/profile/votes";

    @PostMapping(value = "/{restId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@PathVariable int restId) {
        Vote created = super.getOneByDate(LocalDate.now());

        if (created == null) {
            super.create(restId);
        } else {
            super.update(created, restId);
        }
    }

    @GetMapping
    public List<Vote> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/today")
    public List<Vote> getToday() {
        return super.getAllByDate(LocalDate.now());
    }

    @GetMapping(value = "/todayRating")
    public List<Vote> getTodayRating() {
        return null;
    }
}
