package com.bubble.input;

import java.util.ArrayList;
import java.util.List;

public class MouseListener implements IMouseListener, IMouseEventDispatcher {

    private List<IMouseListener> listeners;

    public MouseListener() {
        listeners = new ArrayList<>();
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        listeners.forEach(listener -> listener.onMouseMove(mouse));
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        listeners.forEach(listener -> listener.onMouseClick(mouse));
    }
    
    public void addListener(IMouseListener listener) {
        listeners.add(listener);
    }

    public MouseListener setOnClick(IMouseClickListener listener) {
        listeners.add(listener);
        return this;
    }

    public MouseListener setOnMove(IMouseMoveListener listener) {
        listeners.add(listener);
        return this;   
    }

    public MouseListener setOnMouseEnter(IMouseEnterListener listener) {
        listeners.add(listener);
        return this;
    }

    public MouseListener setOnMouseExit(IMouseExitListener listener) {
        listeners.add(listener);
        return this;
    }

    public void reset() {
        listeners.clear();
    }

    @Override
    public void onMouseExit(MouseState mouse) {
        listeners.forEach(listener -> listener.onMouseExit(mouse));
    }

    @Override
    public void onMouseEnter(MouseState mouse) {
        listeners.forEach(listener -> listener.onMouseEnter(mouse));
    }

    @Override
    public void onMouseRelease(MouseState state) {
        listeners.forEach(listener -> listener.onMouseRelease(state));
    }

    @Override
    public void onMouseDrag(MouseState state) {
        listeners.forEach(listener -> listener.onMouseDrag(state));
    }

    @Override
    public void onMouseRightClick(MouseState state) {
        listeners.forEach(listener -> listener.onMouseRightClick(state));
    }
}