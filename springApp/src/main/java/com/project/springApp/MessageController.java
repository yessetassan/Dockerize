package com.project.springApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> all() {
        return ResponseEntity.ok().body(messageService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findById(@PathVariable Integer id) {

        Optional<Message> message = messageService.getMessage(id);

        return message.map(m ->
                ResponseEntity.ok().body(m)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{name}")
    public ResponseEntity<String> findById(@PathVariable String name) {

        messageService.save(Message.builder()
                        .name(name)
                .build());
        return ResponseEntity.accepted().body("Created Successfully !");
    }


}
