package com.bubble.opengl;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class VertexBuffer {
    
    private final int vao;
    private final int vbo;
    private final int ebo;

    private int indices;

    public VertexBuffer() {
        vao = glGenVertexArrays(); 
        vbo = glGenBuffers();
        ebo = glGenBuffers();
    }

    public void upload(float[] vertices, int[] indices, VertexAttribute... attributes) {
        this.indices = indices.length;

        glBindVertexArray(vao);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);

        for (VertexAttribute attr : attributes) {
            attr.enable();
        }
        
        unbind();
    }

    public void draw() {
        glDrawElements(GL_TRIANGLES, indices, GL_UNSIGNED_INT, 0);
    }

    public void bind() {

        glBindVertexArray(vao);
        // these can be safely removed
        // glBindBuffer(GL_ARRAY_BUFFER, vbo);
        // glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
        // for debugging
        int err = GL11.glGetError();
        if (err != GL11.GL_NO_ERROR) throw new RuntimeException(String.valueOf(err));
    }

    public void unbind() {
        glBindVertexArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public void destroy() {
        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);
    }
}