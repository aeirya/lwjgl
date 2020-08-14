package com.bubble.input;

import com.bubble.std.Point;

public class MouseState {
    public final Point location;
    public final boolean isMoved;
    
    public MouseState(Point location, boolean isMoved) {
        this.location = location;
        this.isMoved = isMoved;
    }
}