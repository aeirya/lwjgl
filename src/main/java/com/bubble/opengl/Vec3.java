package com.bubble.opengl;

public class Vec3 implements IVertex {

    public final float x;
    public final float y;
    public final float z;

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public void append(float[] vertexBuffer, int index) {
        vertexBuffer[index] = x;
        vertexBuffer[index + 1] = y;
        vertexBuffer[index + 2] = z;
    }
}