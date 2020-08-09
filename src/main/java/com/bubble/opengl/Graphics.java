package com.bubble.opengl;

public class Graphics {
    
    private final Program shader;

    public Graphics() {
        shader = new DummyProgram();
    }

    public void setColor(float r, float g, float b) {
        //
    }

    public void fillRect(VertexBufferBuilder vbb, float x, float y, float w, float h) {
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vertex(x, y + h, 0.0f));
        vbb.addVertex(new Vertex(x + w, y + h, 0.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.setAttribute(0, 3, 3);
        vbb.end();
    }

    public void draw(VertexBuffer vb) {
        shader.bind();
        vb.bind();
        vb.draw();
    }
}