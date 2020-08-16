package com.bubble.gui.element;

import com.bubble.gui.IGuiRenderer;

public interface IButton extends IElement {

    @Override
    default ElementType getType() {
        return ElementType.BUTTON;
    }

    @Override
    default void renderComponent(IGuiRenderer r) {
        r.drawButton(this);
    }
}