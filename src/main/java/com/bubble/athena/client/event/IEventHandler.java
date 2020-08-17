package com.bubble.athena.client.event;

public interface IEventHandler {
    default void handle(IEvent event) {
        event.process(this);
    }
}