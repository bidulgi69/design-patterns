package org.example.singleflightpattern.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final Snowflake snowflake;
    private final SingleFlightRepositoryProxy cacheService;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Autowired
    public MessageService(SingleFlightRepositoryProxy cacheService,
                          R2dbcEntityTemplate r2dbcEntityTemplate
    ) {
        this.snowflake = new Snowflake();
        this.cacheService = cacheService;
        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
    }

    public Mono<Message> saveMessage(long channelId, long userId, String content) {
        return r2dbcEntityTemplate.insert(new Message(
            snowflake.nextId(),
            channelId,
            userId,
            content
        ));
    }

    public Flux<Message> getMessages(long from, long to) {
        long fromId = (from - snowflake.getCustomEpoch()) << 22;
        long toId = (to - snowflake.getCustomEpoch()) << 22;

        return cacheService.getMessages(fromId, toId);
    }
}
