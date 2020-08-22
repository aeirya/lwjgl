package com.bubble.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.ByteBuffer;

public class Texture2D extends Texture {

    protected final int width;
    protected final int height;
    private final ByteBuffer data;  

    public Texture2D(int width, int height, ByteBuffer data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Texture2D(int width, int height) {
        this.width = width;
        this.height = height;
        data = null;
    }
    
    @Override
    public void bind() {
        bind(GL_TEXTURE_2D);
    }

    @Override
    public void unbind() {
        unbind(GL_TEXTURE_2D);
    }

    public void upload(ByteBuffer data, int format, int type) {
        bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_BORDER);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_BORDER);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, format, width, height, 0, format, type, data);
        glGenerateMipmap(GL_TEXTURE_2D);
    }

    @Override
    public void upload() {
        upload(data, GL_RGBA, GL_UNSIGNED_BYTE);
    }
}