package com.bubble.input.mouse;

public interface IMouseAdapter extends IMouseListener {
    @Override
    default void onMouseMove(MouseState mouse) {
        // override this
    }

    @Override
    default void onMouseClick(MouseState mouse) {
        // override this
    }

    @Override
    default void onMouseEnter(MouseState mouse) {
        //
    }

    @Override
    default void onMouseExit(MouseState mouse) {
        //
    }

    @Override
    default void onMouseRelease(MouseState state) {
        //
    }

    @Override
    default void onMouseDrag(MouseState state) {
        //
    }
    
    default void onMouseRightClick(MouseState state) {
        //
    }
}