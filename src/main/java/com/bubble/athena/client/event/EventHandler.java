package com.bubble.athena.client.event;

import com.bubble.athena.client.controller.ServerApi;

public class EventHandler implements IEventHandler {

    private ServerApi serverApi;

    public void provideServerApi(ServerApi api) {
        this.serverApi = api;
    }

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }

    @Override
    public void networkRequest(INetowrkRequest request) {
        if (serverApi != null) request.apply(serverApi);
    }
    
}