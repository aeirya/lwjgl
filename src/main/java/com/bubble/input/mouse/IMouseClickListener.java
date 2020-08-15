package com.bubble.input.mouse;

@FunctionalInterface
public interface IMouseClickListener extends IMouseAdapter {
    @Override
    default void onMouseClick(MouseState mouse) {
        onClick(mouse);
    }

    void onClick(MouseState mouse);
}