package com.bubble.gui;

public interface IButton extends IElement {

    @Override
    default ElementType getType() {
        return ElementType.BUTTON;
    }

    @Override
    default void paintComponent(IGuiRenderer r) {
        r.drawButton(this);
    }
}