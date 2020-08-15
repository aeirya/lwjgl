package com.bubble.input;

import com.bubble.input.keyboard.IKeyListener;

public interface IWindowInput {
    void setListener(IMouseInputListener listener);
    void setListener(IKeyListener listener);
}