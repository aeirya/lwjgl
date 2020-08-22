package com.bubble.input.keyboard;

public interface IKeyListener {
    void onKeyPress(IKeyEvent event);
    void onKeyRelease(IKeyEvent event);
    void onKeyHold(IKeyEvent event);
    void onCharCallback(int codepoint);
}