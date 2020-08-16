package com.bubble.gui.card.legacy;

import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class GuiElement {
    private Point location;
    private Dimension size;

    public GuiElement(Point location, Dimension size) {
        this.location = location;
        this.size = size;
    }

    public Dimension getSize() {
        return size;
    }

    public Point getLocation() {
        return location;
    }

    public float getWidth() {
        return size.width;
    }

    public float getHeight() {
        return size.height;
    }

    public float getX() {
        return location.getX();
    }

    public float getY() {
        return location.getY();
    }

}