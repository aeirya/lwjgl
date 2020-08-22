package com.bubble.std;

public class Point {
    
    public final float x;
    public final float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Point sum(Point other) {
        return new Point(
            this.x + other.x, this.y + other.y
        );
    }

    public static Point sum(Point a, Point b) {
        return new Point(
            a.x + b.x, a.y + b.y
        );
    }

    public Point scale(float rX, float rY) {
        return new Point(
            rX * x, rY * y
        );
    }
    
    public Point scale(float r) {
        return scale(r, r);
    }

    public static Point mul(Point a, Point b) {
        return new Point(
            a.x * b.x, a.y * b.y
        );
    }

    public Point mul(Point point) {
        return mul(this, point);
    }

    public String toString() {
        return x + ", " + y;
    }
}