package com.bubble.ui.element;

public interface IButton extends IElement {

    @Override
    default ElementType getType() {
        return ElementType.BUTTON;
    }
}