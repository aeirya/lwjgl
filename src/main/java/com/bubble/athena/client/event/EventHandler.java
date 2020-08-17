package com.bubble.athena.client.event;

public class EventHandler implements IEventHandler {

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }
    
}