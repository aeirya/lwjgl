package com.bubble.input;

public interface IMouseEnterListener extends IMouseAdapter {
    @Override
    default void onMouseEnter(MouseState mouse) {
        onEnter(mouse);
    }

    void onEnter(MouseState mouse);
}