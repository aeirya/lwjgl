package com.bubble.athena.client.event;

public interface IEvent {
    void process(IEventHandler handler);
}