package com.bubble.input;

import java.util.ArrayList;
import java.util.List;

public class MouseInputListener implements IMouseListener, IMouseEventDispatcher {

    private List<IMouseListener> listeners;

    public MouseInputListener() {
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

    public MouseInputListener setOnClick(IMouseClickListener listener) {
        listeners.add(listener);
        return this;
    }

    public MouseInputListener setOnMove(IMouseMoveListener listener) {
        listeners.add(listener);
        return this;   
    }

    public void reset() {
        listeners.clear();
    }
}