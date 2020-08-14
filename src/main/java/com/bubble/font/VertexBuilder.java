package com.bubble.font;

import com.bubble.opengl.Vec2D;
import com.bubble.opengl.Vec4D;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;

public class VertexBuilder {
    private VertexBufferBuilder vbb;
    private float r;
    private float g;
    private float b;
    private float a;
    private boolean hasColor = false;

    public VertexBuilder(VertexFormat vertexFormat) {
        vbb = new VertexBufferBuilder();
        vbb.setAttributes(vertexFormat.get());
    }

    public void begin() {
        vbb.begin();
    }

    public void end() {
        vbb.end();
    }

    public void color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        hasColor = true;
    }

    public void vertex(float x, float y, float u, float v) {
        //do:  check for format
        vbb.addVertex(new Vec2D(x, y));
        if (hasColor) {
            vbb.addVertex(new Vec4D(r, g, b, a));
        }
        vbb.addVertex(new Vec2D(u, v));
    }

    public void addTriangle(int a, int b, int c) {
        vbb.addTriangle(a, b, c);
    }

    public VertexBuffer flush() {
        return vbb.getVAO();
    }
}
