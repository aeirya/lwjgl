package com.bubble.input;

import com.bubble.std.Point;

public class MouseState {
    private final Point location;
    private final boolean isMoved;
    private final boolean isClicked;
    private final boolean isRightClicked;

    public MouseState(Point location, boolean isMoved, boolean isClicked, boolean isRightClicked) {
        this.location = location;
        this.isMoved = isMoved;
        this.isClicked = isClicked;
        this.isRightClicked = isRightClicked;
    }

    public Point getLocation() {
        return location;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public boolean isRightClicked() {
        return isRightClicked;
    }
}