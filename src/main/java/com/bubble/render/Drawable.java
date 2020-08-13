package com.bubble.render;

import com.bubble.opengl.VertexBuffer;

public class Drawable implements IDrawable {
    private final VertexBuffer vb;
    private final Shader shader;

    public Drawable(VertexBuffer vb, Shader shader) {
        this.shader = shader;
        this.vb = vb;
    }

    public void draw() {
        shader.bind();
        vb.bind();
        vb.draw();
    }
}