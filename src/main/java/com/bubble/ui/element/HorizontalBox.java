package com.bubble.ui.element;

import com.bubble.render.Graphics;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class HorizontalBox extends Element {
    
    public HorizontalBox(IElement element) {
        super(element);
    }

    private void arrangeChilderen() {
        float x = position.x;
        float y = position.y;
        float height = 0.09f;
        float offset = 0.01f;
        y -= height;

        for (IElement e : getChildren()) {
            e.setPosition(new Point(x, y));
            e.setSize(new Dimension(getSize().width, height));
            y -= height + offset;
        }
    }

    @Override
    public void renderComponent(Graphics g) {
        arrangeChilderen();
        children.forEach(c -> c.renderComponent(g));
    }
}