package com.bubble.ui.element;

public class Button extends Element implements IButton {
    public Button(IElement element) {
        super(element);
        setAlign(Align.CENTER);
    }    
}