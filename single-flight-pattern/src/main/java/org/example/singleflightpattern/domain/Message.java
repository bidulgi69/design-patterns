package org.example.singleflightpattern.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table(name = "message")
public class Message {

    @Id
    private Long id;

    @Column("channel_id")
    private Long channelId;

    @Column("user_id")
    private Long userId;

    @Column("content")
    private String content;
}
