package com.bubble.input.mouse;

public interface IMouseListener {
    void onMouseMove(MouseState mouse);
    void onMouseClick(MouseState mouse);
    void onMouseExit(MouseState mouse);
    void onMouseEnter(MouseState mouse);
    void onMouseRelease(MouseState state);

    void onMouseDrag(MouseState state);
    void onMouseRightClick(MouseState state);
}