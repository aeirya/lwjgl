package com.bubble.input;

public interface IMouseExitListener extends IMouseAdapter{
    @Override
    default void onMouseExit(MouseState mouse) {
        onExit(mouse);
    }

    void onExit(MouseState mouse);
}