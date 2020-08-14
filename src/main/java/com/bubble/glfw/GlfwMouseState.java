package com.bubble.glfw;

import com.bubble.input.MouseState;
import com.bubble.std.Point;

public class GlfwMouseState {
    private Point position;
    private boolean isMoved;
    private boolean isClicked;
    private boolean isRightClicked;

    public GlfwMouseState() {
        position = new Point(-10, -10);
        isMoved = false;
        isClicked = false;
        isRightClicked = false;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean isMoved) {
        this.isMoved = isMoved;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public boolean isRightClicked() {
        return isRightClicked;
    }

    public void setRightClicked(boolean isRightClicked) {
        this.isRightClicked = isRightClicked;
    }

    public MouseState getState() {
        return new MouseState(position, isMoved, isClicked, isRightClicked);
    }
}