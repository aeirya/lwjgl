package com.bubble.render;

import com.bubble.opengl.Vec2;
import com.bubble.opengl.Vec4;
import com.bubble.opengl.Vec3;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.std.Color;

public class GraphicsBufferBuilder {
    
    public VertexBuffer drawSimpleRectBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vec3(x + w, y, 0.0f));
        vbb.addVertex(new Vec3(x + w, y - h, 0.0f));
        vbb.addVertex(new Vec3(x, y - h, 0.0f));
        vbb.addVertex(new Vec3(x, y, 0.0f));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 3, 3);
        vbb.end();
        return vbb.getVAO();
    }

    public VertexBuffer drawRectBuffer(float x, float y, float w, float h, Color color) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vec3(x + w, y, 0.0f));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec3(x + w, y - h, 0.0f));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec3(x, y - h, 0.0f));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec3(x, y, 0.0f));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 3, 7);
        vbb.setAttribute(1, 4, 7);
        vbb.end();
        return vbb.getVAO();
    }

    public VertexBuffer drawImageBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vec3(x + w, y, 0.0f));
        vbb.addVertex(new Vec2(1.0f, 1.0f));
        vbb.addVertex(new Vec3(x + w, y - h, 0.0f));
        vbb.addVertex(new Vec2(1.0f, 0.0f));
        vbb.addVertex(new Vec3(x, y - h, 0.0f));
        vbb.addVertex(new Vec2(0.0f, 0.0f));
        vbb.addVertex(new Vec3(x, y, 0.0f));
        vbb.addVertex(new Vec2(0.0f, 1.0f));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 3, 5);
        vbb.setAttribute(1, 2, 5);
        vbb.end();
        return vbb.getVAO();
    }
    
    public VertexBuffer drawElementBuffer(float x, float y, float w, float h, Color color) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vec2(x + w, y));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2(1.0f,1.0f));
        vbb.addVertex(new Vec2(x + w, y - h));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2(1.0f, 0.0f));
        vbb.addVertex(new Vec2(x, y - h));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2(0.0f, 0.0f));
        vbb.addVertex(new Vec2(x, y));
        vbb.addVertex(new Vec4(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2(0.0f,1.0f));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 2, 8);
        vbb.setAttribute(1, 4, 8);
        vbb.setAttribute(2, 2, 8);
        vbb.end();
        return vbb.getVAO();
    }
}