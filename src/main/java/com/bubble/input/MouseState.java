package com.bubble.input;

import com.bubble.std.Point;

public class MouseState {
    public final Point location;
    public final boolean isMoved;
    public final boolean isClicked;
    public final boolean isRightClicked;

    public MouseState(Point location, boolean isMoved, boolean isClicked, boolean isRightClicked) {
        this.location = location;
        this.isMoved = isMoved;
        this.isClicked = isClicked;
        this.isRightClicked = isRightClicked;
    }

    public Point getPosition() {
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