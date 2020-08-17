package com.bubble.opengl;

public class Vec2 implements IVertex {

    public final float x;
    public final float y;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public void append(float[] vertexBuffer, int index) {
        vertexBuffer[index] = x;
        vertexBuffer[index + 1] = y;
    }
}