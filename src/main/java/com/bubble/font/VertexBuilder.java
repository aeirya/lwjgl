package com.bubble.font;

import com.bubble.opengl.Vec2;
import com.bubble.opengl.Vec4;
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
        vbb.setAttributes(vertexFormat.toVertAtrib());
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
        vbb.addVertex(new Vec2(x, y));
        vbb.addVertex(new Vec2(u, v));
        if (hasColor) {
            vbb.addVertex(new Vec4(r, g, b, a));
        }
    }

    public void triangle(int a, int b, int c) {
        vbb.addTriangle(a, b, c);
    }

    public VertexBuffer flush() {
        VertexBuffer buffer = vbb.getVAO();
        vbb.clear();
        return buffer;
    }

    public void clear() {
        vbb.clear();
    }
}
