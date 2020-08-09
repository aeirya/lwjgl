package com.bubble.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import org.lwjgl.system.MemoryUtil;

public class VertexAttribute {
    private final int location;
    private final int size;
    private final int stride;

    private static final int SIZE_OF_FLOAT = 4;

    public VertexAttribute(int location, int size, int stride) {
        this.location = location;
        this.size = size;
        this.stride = stride;
    }

    public void enable() {
        glVertexAttribPointer(location, size, GL_FLOAT, false, stride * SIZE_OF_FLOAT, MemoryUtil.NULL);
        glEnableVertexAttribArray(location);
    }

    public void disable() {
        glDisableVertexAttribArray(location);
    }
}