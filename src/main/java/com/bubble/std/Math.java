package com.bubble.std;

public class Math {
    private Math() { }

    public static Point glfwCoordToOpenGl(double x, double y, int width, int height) {
        return new Point(
            ((float) x / width - 0.5f) * 2,
            ((float) y / height - 0.5f) * 2 * (-1)
            );
    }

    @SuppressWarnings("all")
    public static boolean checkInBound(float value, float start, float end) {
        if (start > end) return checkInBound(value, end, start);
        else return (value < end) && (value > start);
    }

    public static Point toPoint(Dimension dim) {
        return new Point(dim.width, dim.height);
    }
}