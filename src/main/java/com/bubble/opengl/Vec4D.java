package com.bubble.opengl;

public class Vec4D implements IVertex {
    public final float x;
    public final float y;
    public final float z;
    public final float w;

    public Vec4D(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public void append(float[] vertexBuffer, int index) {
        vertexBuffer[index] = x;
        vertexBuffer[index + 1] = y;
        vertexBuffer[index + 2] = z;
        vertexBuffer[index + 3] = w;
    }
}