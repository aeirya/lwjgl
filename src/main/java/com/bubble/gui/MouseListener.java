package com.bubble.gui;

import com.bubble.input.IMouseListener;

public abstract class MouseListener implements IMouseListener {
    
    public MouseListener() {

    }

    public void bind(Element element) {
        element.setMouseListener(this);
    }

    
}