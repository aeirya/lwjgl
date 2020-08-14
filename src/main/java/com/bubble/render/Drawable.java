package com.bubble.render;

import com.bubble.opengl.VertexBuffer;

public class Drawable implements IDrawable {
    private final VertexBuffer vb;

    public Drawable(VertexBuffer vb) {
        this.vb = vb;
    }

    public void draw() {
        vb.bind();
        vb.draw();
        vb.unbind();
    }

    public void destroy() {
        vb.destroy();
    }
}