package com.bubble.util.resource;

import com.bubble.opengl.Texture;
import com.bubble.std.Dimension;

public class UiManager {
    private final TextureManager textures;

    public UiManager(TextureManager textures) {
        this.textures = textures;
    }

    public Texture getButtonTexture(Dimension size) {
        if(size.height > size.width * 1.5f)
            return textures.getTexture(EnumTexture.BUTTON_XS);
        if(size.height * 3 <= size.width)
            return textures.getTexture(EnumTexture.BUTTON_LG);
        else return textures.getTexture(EnumTexture.BUTTON_MD);
    }
}
