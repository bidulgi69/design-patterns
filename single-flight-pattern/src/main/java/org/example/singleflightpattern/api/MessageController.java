package org.example.singleflightpattern.api;

import org.example.singleflightpattern.domain.Message;
import org.example.singleflightpattern.domain.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Mono<Void> createMessage(@RequestBody CreateMessageRequest request) {
        return messageService.saveMessage(request.channelId(), request.userId(), request.content())
            .then();
    }

    @GetMapping
    public Flux<Message> getMessages(@RequestParam(name = "from") long from,
                                     @RequestParam(name = "to") long to
    ) {
        return messageService.getMessages(from, to);
    }
}
