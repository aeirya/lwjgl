package com.bubble.athena.client.event;

public class EventSystem {

    private static class InstanceHolder {
        static EventSystem instance = new EventSystem();
    }

    private static EventSystem getInstance() {
        return InstanceHolder.instance;
    }

    private EventSystem() { }

    private IEventHandler handler;

    public static void start(IEventHandler handler) {
        getInstance().handler = handler;
    }

    public static void push(IEvent event) {
        getInstance().handler.handle(event);
    }
}