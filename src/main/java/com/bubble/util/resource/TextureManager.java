package com.bubble.util.resource;

import java.util.Map;
import java.awt.image.BufferedImage;

import com.bubble.opengl.Texture;
import com.bubble.util.config.Config;

public class TextureManager {
    private final Map<String, Texture> textures;

    public TextureManager() {
        textures = loadTextures(Config.getTexturePath());
    }
    
    public Texture getTexture(String name) {
        return textures.getOrDefault(name, null);
    }

    public Texture getTexture(EnumTexture texture) {
        return getTexture(texture.get());
    }
    
    public Texture loadBufferedImage(BufferedImage image) {
        return new ImageLoader().loadBufferedImage(image);
    }

    private Map<String, Texture> loadTextures(String path) {
        return new ImageLoader().loadDir(path, true);
    }

    // notice: TEXTURE_2D, TEXTURE_ARRAY
}