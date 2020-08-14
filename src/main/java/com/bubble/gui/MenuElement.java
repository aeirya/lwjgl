package com.bubble.gui;

import com.bubble.input.IMouseEventDispatcher;
import com.bubble.input.IMouseListener;
import com.bubble.input.MouseInputListener;
import com.bubble.input.MouseState;

public class MenuElement extends Element implements IMouseListener {
    private final MouseInputListener listener;

    public MenuElement() {
        listener = new MouseInputListener();
        this.setMouseListener(listener);
    }

    public void listen(IMouseEventDispatcher dispatcher) {
        dispatcher.addListener(listener);
    }
    
    public void addListener(IMouseListener list) {
        listener.addListener(list);
    }

    public void onMouseMove(MouseState mouse) {
        listener.onMouseMove(mouse);
    }

    public void onMouseClick(MouseState mouse) {
        listener.onMouseClick(mouse);
    }

}