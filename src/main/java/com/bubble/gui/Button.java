package com.bubble.gui;

import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class Button extends Element implements IButton {
    public Button() {
        
        this.setSize(new Dimension(0.2f, 0.4f));
        this.setPosition(new Point(0,0));
        this.setColor(Color.GRAY);
        this.setType(ElementType.BUTTON);
    }    
}