package ru.graduation.topjava.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.graduation.topjava.model.Vote;
import ru.graduation.topjava.repository.vote.VoteRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.graduation.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService(VoteRepository voteRepository) {
        this.repository = voteRepository;
    }

    public Vote create(Vote vote, int userId, int restId) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote, userId, restId);
    }

    public void update(Vote vote, int userId, int restId) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote, userId, restId), vote.getId());
    }

    public Vote get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Vote getByIdAndUserId(int id, int userId) {
        return repository.getByIdAndUserId(id, userId);
    }

    public Vote getByUserIdAndDate(int userId, LocalDate date) {
        return repository.getByUserIdAndDate(userId, date);
    }

    public List<Vote> getAll() {
        return repository.getAll();
    }

    public List<Vote> getAllByDate(LocalDate date) {
        return repository.getAllByDate(date);
    }
}
