package com.bubble.athena.client.services;

import com.bubble.util.resource.TextureManager;

public class ServiceLocator {
    
    private TextureManager textures;

    private ServiceLocator() { }

    private static class InstanceHolder {
        private static final ServiceLocator instance = new ServiceLocator();
    }

    public static ServiceLocator getInstance() {
        return InstanceHolder.instance;
    }

    public ServiceLocator provideTextureManager(TextureManager texturess) {
        this.textures = texturess;
        return this;
    }

    public static TextureManager getTextureManager() {
        return getInstance().textures;
    }
}