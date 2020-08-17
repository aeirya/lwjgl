package com.bubble.athena.client;

import com.bubble.athena.client.event.EventHandler;
import com.bubble.athena.client.event.EventSystem;
import com.bubble.athena.client.event.IEventHandler;
import com.bubble.graphics.GameGraphics;

public class Client {
    
    private final GameGraphics graphics;
    private final IEventHandler eventHandler;

    public Client() {
        eventHandler = new EventHandler();
        EventSystem.start(eventHandler);
        graphics = new GameGraphics();
        graphics.start();
    }

    public static void main(String[] args) {
        new Client();
    }
}