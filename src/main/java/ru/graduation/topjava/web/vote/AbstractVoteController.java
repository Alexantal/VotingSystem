package ru.graduation.topjava.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.graduation.topjava.model.Vote;
import ru.graduation.topjava.service.VoteService;
import ru.graduation.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.util.List;

import static ru.graduation.topjava.util.ValidationUtil.*;

public abstract class AbstractVoteController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService service;

    public Vote create(int restId) {
        int userId = SecurityUtil.authUserId();
        log.info("create new vote for user {}", userId);
        return service.create(new Vote(null, LocalDate.now()), userId, restId);
    }

    public void update(Vote vote, int restId) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user {}", vote, userId);
//        assureIdConsistent(vote, id);
        service.update(vote, userId, restId);
    }

    public Vote get(int id) {
        log.info("get vote {}", id);
        return checkNotFoundWithId(service.get(id), id);
    }

    public List<Vote> getAll() {
        log.info("get All");
        return service.getAll();
    }

    public Vote getOneByDate(LocalDate date) {
        int userId = SecurityUtil.authUserId();
        log.info("get vote for userId: {} and date: {} ", userId, date);
        return service.getByUserIdAndDate(userId, date);
    }

    public List<Vote> getAllByDate(LocalDate date) {
        log.info("get All for date {}", date);
        return service.getAllByDate(date);
    }
}
