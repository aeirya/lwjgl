package com.bubble.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.ByteBuffer;

public class Texture2D extends Texture {

    private final int width;
    private final int height;
    private final ByteBuffer data;

    public Texture2D(int width, int height, ByteBuffer data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }
    
    @Override
    public void bind() {
        bind(GL_TEXTURE_2D);
    }

    @Override
    public void unbind() {
        unbind(GL_TEXTURE_2D);
    }

    @Override
    public void upload() {
        bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
}