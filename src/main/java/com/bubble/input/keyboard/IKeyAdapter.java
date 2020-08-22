package com.bubble.input.keyboard;

public interface IKeyAdapter extends IKeyListener {
    @Override
    default void onKeyHold(IKeyEvent event) {
        //
    }

    @Override
    default void onKeyPress(IKeyEvent event) {
        //
    }

    @Override
    default void onKeyRelease(IKeyEvent event) {
        //
    }

    @Override
    default void onCharCallback(int codepoint) {
        //
    }
}