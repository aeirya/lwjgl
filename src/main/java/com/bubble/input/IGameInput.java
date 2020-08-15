package com.bubble.input;

import com.bubble.input.keyboard.IKeyListener;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.input.mouse.IWindowInput;

public interface IGameInput {
    void bind(IWindowInput window);
    void bindListener(IMouseListener listener);
    void bindListener(IKeyListener listener);
}