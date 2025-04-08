package org.example.singleflightpattern.domain.repository;

import org.example.singleflightpattern.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {

    // get rows between two timestamps
    Flux<Message> findAllByIdBetween(long from, long to);
}
