package com.bubble.input.mouse;

public interface IMouseInputListener {
    void onMouseMove(MouseState mouse);
    void onMouseClick(MouseState mouse);   
    void onMouseRelease(MouseState mouse);
    void listen(IWindowInput window);
}