package com.bubble.ui.element;

public class Button extends Element implements IButton {
    public Button(IElement element) {
        super(element);
        setType(ElementType.BUTTON);
        setAlign(Align.CENTER);
    }

    public Button() {
        setType(ElementType.BUTTON);
        setAlign(Align.CENTER);
    }
}