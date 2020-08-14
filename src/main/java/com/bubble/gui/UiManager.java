package com.bubble.gui;

import com.bubble.opengl.Texture;
import com.bubble.std.Dimension;
import com.bubble.util.resource.EnumTexture;
import com.bubble.util.resource.TextureManager;

public class UiManager {
    private final TextureManager textures;

    public UiManager(TextureManager textures) {
        this.textures = textures;
    }

    public Texture getButtonTexture(Dimension size) {
        if(size.height > size.width * 1.5f) return textures.getTexture(EnumTexture.BUTTON_SMALL);
        else if(size.height * 3 <= size.width) return textures.getTexture(EnumTexture.BUTTON_BIG);
        else return textures.getTexture(EnumTexture.BUTTON_MED);
    }
}
