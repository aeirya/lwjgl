package com.bubble.input;

public interface IMouseAdapter extends IMouseListener {
    @Override
    default void onMouseMove(MouseState mouse) {
        // override this
    }

    @Override
    default void onMouseClick(MouseState mouse) {
        // override this
    }
}