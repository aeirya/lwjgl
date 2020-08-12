package com.bubble.render;

import java.util.ArrayList;
import java.util.List;

import com.bubble.opengl.Texture;
import com.bubble.opengl.Vec2D;
import com.bubble.opengl.Vertex;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;

public class Graphics implements IRenderer {
    
    private List<IDrawable> drawables;

    public Graphics() {
        drawables = new ArrayList<>();
    }

    public void setColor(float r, float g, float b, float a) {
        //
    }

    public void clear() {
        drawables.clear();
    }

    private void add(VertexBuffer vb, Shader shader) {
        drawables.add(new Drawable(vb, shader));
    }

    private void add(VertexBuffer vb, Texture texture) {
        texture.upload();
        drawables.add(new TextureDrawable(vb, texture, Shader.getTextureShader()));
        vb.unbind();
    }

    private void addElement(VertexBuffer vb, Texture texture) {
        texture.upload();
        drawables.add(new TextureDrawable(vb, texture, Shader.getElementShader()));
    }

    public void fillRect(float x, float y, float w, float h) {
        add(fillRectBuffer(x, y, w, h), Shader.getShapeShader());
    }

    private VertexBuffer fillRectBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vertex(x, y + h, 0.0f));
        vbb.addVertex(new Vertex(x + w, y + h, 0.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.setAttribute(0, 3, 3);
        vbb.end();
        return vbb.getVAO();
    }

    public void drawImage(float x, float y, float w, float h, Texture texture) {
        add(drawImageBuffer(x, y, w, h), texture);
    }

    private VertexBuffer drawImageBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.0f));
        // vbb.addVertex(new Vec2D(x, y));
        vbb.addVertex(new Vec2D(0.0f, 0.0f));
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        // vbb.addVertex(new Vec2D(x + w, y));
        vbb.addVertex(new Vec2D(1.0f, 0.0f));
        vbb.addVertex(new Vertex(x, y + h, 0.0f));
        // vbb.addVertex(new Vec2D(x, y + h));
        vbb.addVertex(new Vec2D(0.0f,1.0f));
        vbb.addVertex(new Vertex(x + w, y + h, 0.0f));
        // vbb.addVertex(new Vec2D(x + w, y + h));
        vbb.addVertex(new Vec2D(1.0f,1.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.setAttribute(0, 3, 5);
        vbb.setAttribute(3, 2, 5);
        vbb.end();
        return vbb.getVAO();
    }

    public void drawElementImage(float x, float y, float w, float h, Texture texture) {
        addElement(drawElementBuffer(x, y, w, h), texture);
    }

    private VertexBuffer drawElementBuffer(float x, float y, float w, float h) {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        vbb.addVertex(new Vec2D(x, y));
        vbb.addVertex(new Vec2D(0.0f, 0.0f));
        vbb.addVertex(new Vec2D(x + w, y));
        vbb.addVertex(new Vec2D(1.0f, 0.0f));
        vbb.addVertex(new Vec2D(x, y + h));
        vbb.addVertex(new Vec2D(0.0f,1.0f));
        vbb.addVertex(new Vec2D(x + w, y + h));
        vbb.addVertex(new Vec2D(1.0f,1.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.setAttribute(0, 2, 4);
        vbb.setAttribute(3, 2, 4);
        vbb.end();
        return vbb.getVAO();
    }
    

    public void draw() {
        drawables.forEach(IDrawable::draw);
    }
    
    public void render() {
        draw();
    }
}