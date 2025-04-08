package org.example.singleflightpattern.api;

public record CreateMessageRequest(
    long channelId,
    long userId,
    String content
) {
}
