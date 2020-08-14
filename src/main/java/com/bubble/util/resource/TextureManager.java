package com.bubble.util.resource;

import java.util.Map;

import com.bubble.opengl.Texture;

public class TextureManager {
    private final Map<String, Texture> textures;
    private static final String TEXTURE_PATH = "./assets/texture/";

    public TextureManager() {
        textures = loadTextures(TEXTURE_PATH);
        textures.putAll(loadTextures(TEXTURE_PATH + "button/"));
    }
    
    public Texture getTexture(String name) {
        return textures.getOrDefault(name, null);
    }

    private Map<String, Texture> loadTextures(String path) {
        return new ImageLoader().loadDir(path, true);
    }
}