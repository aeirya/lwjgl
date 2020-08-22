package com.bubble.std;

public class Dimension {
    
    public final float width;
    public final float height;

    public Dimension(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Dimension scaled(Float ratio) {
        return new Dimension(
            (ratio * width), (ratio * height));
    }

    public Dimension scaled(float rX, float rY) {
        return new Dimension(width * rX, height * rY);
    }

    @Override
    public String toString() {
        return "(" + width + "," + height + ")";
    }
}