package com.bubble.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class VertexAttribute {
    private final int location;
    private final int size;
    private final int stride;
    private final long offset;

    private static final int SIZE_OF_FLOAT = 4;

    public VertexAttribute(int location, int size, int stride, int offset) {
        this.location = location;
        this.size = size;
        this.stride = stride;
        this.offset = offset;
    }

    public void enable() {
        glVertexAttribPointer(location, size, GL_FLOAT, false, stride * SIZE_OF_FLOAT, offset * SIZE_OF_FLOAT);
        glEnableVertexAttribArray(location);
    }

    public void disable() {
        glDisableVertexAttribArray(location);
    }

    public int getSize() {
        return size;
    }
}