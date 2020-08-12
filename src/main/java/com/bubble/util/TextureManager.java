package com.bubble.util;

import java.util.HashMap;
import java.util.Map;

import com.bubble.opengl.Texture;

public class TextureManager {
    private final Map<String, Texture> textures;
    private final ImageLoader imageLoader;

    public TextureManager() {
        textures = new HashMap<>();
        imageLoader = new ImageLoader();
        addCat();
    }
    
    public Texture getTexture(String name) {
        return textures.get(name);
    }

    private void addCat() {
        String path = "/Users/madscientist/Desktop/opengl/lwjgl/assets/container.png";
        textures.put("cat", loadTexture(path));
    }

    private Texture loadTexture(String path) {
        return imageLoader.loadTexure2D(path);
    }
}