package com.bubble.ui.element;

import java.util.ArrayList;
import java.util.List;

import com.bubble.font2.Font;
import com.bubble.render.Graphics;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class TableElement extends Element {

    private RowElement header;

    private int start = 0;

    public TableElement() { }

    public TableElement(String id, Point position, Dimension size, Font font, Color color) {
        setId(id);
        setPosition(position);
        setSize(size);
        setColor(color);
        setFont(font);
        setChildren(new ArrayList<>());
        setType(ElementType.TABLE);
        // arrangeChilderen();
    }

    private void arrangeChilderen() {
        float x = position.x + 0.08f;
        float y = position.y - 0.04f;
        float yOffset = 0.09f;
        float xOffset;
        
        for (IElement e : this.header.getElement()) {
            e.setPosition(new Point(x, y));
            x += getElementXOffset(this.header);
        }
        y -= yOffset + 0.02f;

        for (int i = start; i < this.children.size(); ++i) {
            RowElement child = (RowElement) this.children.get(i);

            x = position.x + 0.08f;
            xOffset = getElementXOffset(child);

            for (IElement e : child.getElement()) {
                e.setPosition(new Point(x, y));
                x += xOffset;
            }
            y -= yOffset;
        }
    }

    private float getElementXOffset(RowElement e) {
        return size.width / e.getElement().size();
    }

    public void scrollUp(int n) {
        start -= n;
        if (start < 0) start = 0;
    }

    public void scrollDown(int n) {
        start += n;
        if (start > this.children.size()-1) start = this.children.size()-1;
        if (start < 0) start = 0;
    }

    public void setHeader(List<String> s) {
        header = new RowElement(s);
    }

    public void addRow(List<String> s) {
        children.add(new RowElement(s));
    }

    public void removeRow(int index) {
        children.remove(index);
    }

    public void removeRow() {
        removeRow(this.children.size()-1);
    }

    @Override
    public void renderComponent(Graphics g) {
        arrangeChilderen();
        header.renderComponent(g);
        children.forEach(c -> c.renderComponent(g));
        g.render();
    }
}