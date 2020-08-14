package com.bubble.input;

@FunctionalInterface
public interface IMouseMoveListener extends IMouseAdapter {
    
    @Override
    default void onMouseMove(MouseState mouse) {
        onMove(mouse);
    }

    void onMove(MouseState mouse);
}
