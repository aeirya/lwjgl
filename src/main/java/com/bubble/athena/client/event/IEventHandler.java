package com.bubble.athena.client.event;

public interface IEventHandler {
    void networkRequest(INetowrkRequest request);
    void handle(IEvent event);
}