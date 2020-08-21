package com.bubble.render;

import com.bubble.font2.Font;
import com.bubble.opengl.Texture;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public interface IAdvancedGraphics extends IGraphics {
    default void setColor(Color color) {
        setColor(color.r, color.g, color.b, color.a);
    }

    default void drawImage(Point pos, Dimension size, Texture texture) {
        drawImage(pos.x, pos.y, size.width, size.height, texture);
    }

    default void drawRect(Point position, Dimension size, Color color) {
        setColor(color);
        drawRect(position, size);
    }

    default void drawRect(Point position, Dimension size) {
        drawRect(position.x, position.y, size.width, size.height);
    }

    default void drawElement(Point position, Dimension size, Texture texture, Color color) {
        setColor(color);
        drawElement(position, size, texture);
    }

    default void drawElement(Point position, Dimension size, Texture texture) {
        drawElement(position.x, position.y, size.width, size.height, texture);
    }

    default void drawText(String text, Point location, float scale) {
        drawText(text, location.x, location.y , scale);
    }

    default void drawText(String text, Point location, float scale, Font font) {
        setFont(font);
        drawText(text, location, scale);
    }
}