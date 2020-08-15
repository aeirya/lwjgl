package com.bubble.input.keyboard;

import com.bubble.input.mouse.IWindowInput;

public class KeyboardInput implements IKeyListener {
    private IKeyListener listener;

    public KeyboardInput(IWindowInput window) {
        listen(window);
    }

    public void listen(IWindowInput window) {
        window.setListener(this);
    }

    @Override
    public void onKeyPress(IKeyEvent event) {
        if (listener != null) listener.onKeyPress(event);
    }

    @Override
    public void onKeyRelease(IKeyEvent event) {
        if (listener != null) listener.onKeyRelease(event);
    }

    @Override
    public void onKeyHold(IKeyEvent event) {
        if (listener != null) listener.onKeyHold(event);
    }

    @Override
    public void onCharCallback(int codepoint) {
        if (listener != null) listener.onCharCallback(codepoint);
    }

    public void setListener(IKeyListener listener) {
        this.listener = listener;
    }
}