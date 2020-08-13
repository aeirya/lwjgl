package com.bubble.render;

import com.bubble.opengl.Texture;
import com.bubble.opengl.VertexBuffer;

public class TextureDrawable implements IDrawable {

    private final Texture texture;
    private final VertexBuffer vb;

    public TextureDrawable(VertexBuffer vb, Texture texture) {
        this.texture = texture;
        this.vb = vb;
    }

    @Override
    public void draw() {
        // we could've been binding shaders here
        texture.bind();
        vb.bind();
        vb.draw();
        texture.unbind();
    }
}