package com.bubble.input.mouse;

public interface IMouseReleaseListener extends IMouseAdapter {
    @Override
    default void onMouseRelease(MouseState state) {
        onRelease(state);
    }

    void onRelease(MouseState state);
}
