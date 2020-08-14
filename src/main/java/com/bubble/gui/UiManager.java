package com.bubble.gui;

import com.bubble.opengl.Texture;
import com.bubble.std.Dimension;
import com.bubble.util.resource.TextureManager;

public class UiManager {
    private final TextureManager textures;

    public UiManager(TextureManager textures) {
        this.textures = textures;
    }

    public Texture getButtonTexture(Dimension size) {
        return
        (size.height > size.width * 1.5f) ? 
            textures.getTexture("button-xs") : (size.height * 3 <= size.width) ?
            textures.getTexture("button-lg") : textures.getTexture("button-md");
    }
}
