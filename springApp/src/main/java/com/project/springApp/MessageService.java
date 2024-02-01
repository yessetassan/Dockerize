package com.project.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final Repo repo;

    @Autowired
    public MessageService(Repo repo) {
        this.repo = repo;
    }

    public Optional<Message> getMessage(Integer id) {
        return repo.findById(id);
    }

    public List<Message> all() {
        return repo.findAll();
    }

    public void save(Message message) {
        repo.save(message);
    }
}
