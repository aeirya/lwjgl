package com.bubble.athena.client;

import com.bubble.athena.client.controller.Network;
import com.bubble.athena.client.controller.ServerApi;
import com.bubble.athena.client.event.EventHandler;
import com.bubble.athena.client.event.EventSystem;
import com.bubble.athena.client.event.IEventHandler;
import com.bubble.athena.client.services.ServiceLocator;
import com.bubble.graphics.GameGraphics;
import com.bubble.util.resource.TextureManager;

public class Client {
    
    public Client() {
        initiateSubsystems();
    }
    
    private void initiateSubsystems() {
        IEventHandler eventHandler = new EventHandler();
        GameGraphics graphics = new GameGraphics();
        TextureManager textures = new TextureManager();
        
        ServerApi api = new ServerApi();
        Network.provideApi(api);
        
        EventSystem.start(eventHandler);
        ServiceLocator.getInstance().provideTextureManager(textures);
        graphics.start();
    }

    public static void main(String[] args) {
        new Client();
    }
}