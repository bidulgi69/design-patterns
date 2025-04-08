package org.example.singleflightpattern.domain;

import org.example.singleflightpattern.domain.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
@Transactional(readOnly = true)
public class SingleFlightRepositoryProxy {

    private final MessageRepository messageRepository;
    private final ConcurrentNavigableMap<Integer, Flux<Message>> cache;

    @Autowired
    public SingleFlightRepositoryProxy(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.cache = new ConcurrentSkipListMap<>();
    }

    public Flux<Message> getMessages(long from, long to) {
        int hash = generateHash("getMessages", from, to);
        return Optional.ofNullable(cache.getOrDefault(hash, null))
            .orElseGet(() -> {
                Flux<Message> data = messageRepository.findAllByIdBetween(from, to)
                    .cache(Duration.ofMillis(3_000L));
                cache.put(hash, data);
                return data;
            });
    }

    private int generateHash(Object... args) {
        return Objects.hash(args);
    }
}
