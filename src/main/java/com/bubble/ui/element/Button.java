package com.bubble.ui.element;

import com.bubble.render.Graphics;
import com.bubble.std.Color;
import com.bubble.std.Point;

public class Button extends Element implements IButton {
    public Button(IElement element) {
        super(element);
        setType(ElementType.BUTTON);
        setAlign(Align.CENTER);
    }

    public Button() {
        setType(ElementType.BUTTON);
        setAlign(Align.CENTER);
        setColor(Color.WHITE);
    }

    @Override
    public void renderComponent(Graphics g) {
        // g.drawText("HI", getPosition(), 0.017f);
        // g.render();
    }
}