package com.bubble.std;

public class Color {
    public final float r;
    public final float g;
    public final float b;
    public final float a;

    /** RGB values from 0 to 255 */
    public Color(int r, int g, int b, float a) {
        this.r = (float)(r)/ 255;
        this.g = (float)(g)/ 255;
        this.b = (float)(b)/ 255;
        this.a = a;
    }
    
    /** float values form 0.0f to 1.0f */
    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(float r, float g, float b) {
        this(r, g, b, 1.0f);
    }

    public Color(int r, int g, int b) {
        this(r, g, b, 1.0f);
    }

    public int getRed() {
        return (int)(255 * r);
    }

    public int getGreen() {
        return (int)(255 * r);
    }
    
    public int getBlue() {
        return (int)(255 * b);
    }

    public float getAlpha() {
        return a;
    }

    public String toString() {
        return "(" + 
            getRed() + "," + getGreen() + "," + getBlue() + "," + getAlpha()
            + ")";
    }
}