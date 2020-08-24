package com.bubble.ui.element;

import com.bubble.render.Graphics;
import com.bubble.std.Point;

public class HorizontalBox extends Element {
    
    public HorizontalBox(IElement element) {
        super(element);
    }

    private void arrangeChilderen() {
        float x = position.x + 0.08f;
        float y = position.y - 0.04f;
        float yOffset = 0.09f;

        y -= yOffset + 0.02f;

        for (IElement e : getChildren()) {
            e.setPosition(new Point(x, y));
            y -= yOffset;
        }
    }

    @Override
    public void renderComponent(Graphics g) {
        arrangeChilderen();
        children.forEach(c -> c.renderComponent(g));
    }
}