package com.bubble.opengl;

import static org.lwjgl.opengl.GL11.*;

public abstract class Texture {
    protected final int id;

    public Texture() {
        id = glGenTextures();
    }

    public abstract void bind();
    public abstract void unbind();
    public abstract void upload();

    protected void bind(int target) {
        glBindTexture(target, id);
    }
    
    protected void unbind(int target) {
        glBindTexture(target, 0);
    }

    public void destroy() {
        glDeleteTextures(id);
    }
}