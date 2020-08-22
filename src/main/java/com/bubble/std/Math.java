package com.bubble.std;

import com.bubble.font2.Font;
import com.bubble.font2.IGlyph;

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

    public static float getTextWidth(String text, float scale, Font font) {
		float length = 0f;

		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			IGlyph glyph = font.getGlyph(c);
			float advance = glyph.getWidth(0, scale);
			length += advance;
		}
            
        return length;
    }
}