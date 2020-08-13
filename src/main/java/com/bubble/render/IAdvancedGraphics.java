package com.bubble.render;

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

    default void drawRect(Point pos, Dimension size, Color color) {
        setColor(color);
        drawRect(pos.x, pos.y, size.width, size.height);
    }
}