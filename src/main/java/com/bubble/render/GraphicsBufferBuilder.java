package com.bubble.render;

import com.bubble.opengl.Vec2D;
import com.bubble.opengl.Vec4D;
import com.bubble.opengl.Vertex;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.std.Color;

public class GraphicsBufferBuilder {
    
    public VertexBuffer drawSimpleRectBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vertex(x + w, y - h, 0.0f));
        vbb.addVertex(new Vertex(x, y - h, 0.0f));
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 3, 3);
        vbb.end();
        return vbb.getVAO();
    }

    public VertexBuffer drawRectBuffer(float x, float y, float w, float h, Color color) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vertex(color.r, color.g, color.b));
        vbb.addVertex(new Vertex(x + w, y - h, 0.0f));
        vbb.addVertex(new Vertex(color.r, color.g, color.b));
        vbb.addVertex(new Vertex(x, y - h, 0.0f));
        vbb.addVertex(new Vertex(color.r, color.g, color.b));
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vertex(color.r, color.g, color.b));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 3, 6);
        vbb.setAttribute(1, 3, 6);
        vbb.end();
        return vbb.getVAO();
    }

    public VertexBuffer drawImageBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vec2D(1.0f, 1.0f));
        vbb.addVertex(new Vertex(x + w, y - h, 0.0f));
        vbb.addVertex(new Vec2D(1.0f, 0.0f));
        vbb.addVertex(new Vertex(x, y - h, 0.0f));
        vbb.addVertex(new Vec2D(0.0f, 0.0f));
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vec2D(0.0f, 1.0f));
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
        vbb.addVertex(new Vec2D(x + w, y));
        vbb.addVertex(new Vec4D(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2D(1.0f,1.0f));
        vbb.addVertex(new Vec2D(x + w, y - h));
        vbb.addVertex(new Vec4D(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2D(1.0f, 0.0f));
        vbb.addVertex(new Vec2D(x, y - h));
        vbb.addVertex(new Vec4D(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2D(0.0f, 0.0f));
        vbb.addVertex(new Vec2D(x, y));
        vbb.addVertex(new Vec4D(color.r, color.g, color.b, color.a));
        vbb.addVertex(new Vec2D(0.0f,1.0f));
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);
        vbb.setAttribute(0, 2, 8);
        vbb.setAttribute(1, 4, 8);
        vbb.setAttribute(2, 2, 8);
        vbb.end();
        return vbb.getVAO();
    }
}