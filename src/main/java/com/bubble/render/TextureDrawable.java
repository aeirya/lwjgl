package com.bubble.render;

import com.bubble.opengl.Texture;
import com.bubble.opengl.VertexBuffer;

public class TextureDrawable implements IDrawable {

    private final Texture texture;
    private final Shader shader;
    private final VertexBuffer vb;

    public TextureDrawable(VertexBuffer vb, Texture texture, Shader shader) {
        this.shader = shader;
        this.texture = texture;
        this.vb = vb;
    }

    @Override
    public void draw() {
        texture.bind();
        shader.bind();
        vb.bind();
        vb.draw();
        texture.unbind();
    }
}