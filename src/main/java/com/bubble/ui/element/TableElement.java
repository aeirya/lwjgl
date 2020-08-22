package com.bubble.ui.element;

import java.util.List;

import com.bubble.input.mouse.IMouseListener;
import com.bubble.render.Graphics;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class TableElement extends Element {
    private String id;
    private int col = 1;
    private Point position;
    private Dimension size;
    private Color color;
    private String texture;
    private Align textAlign;
    private boolean isDisabled;
    private boolean isHidden;
    private IMouseListener listener;

    private List<RowElement> children;
    private RowElement header;

    TableElement() { }

    TableElement(String id, Point position, Dimension size, Align align, Color color,
            String texture, boolean isDisabled, boolean isHidden, List<RowElement> children) {
        this.id = id;
        this.position = position;
        this.size = size;
        this.color = color;
        this.texture = texture;
        this.isDisabled = isDisabled;
        this.isHidden = isHidden;
        this.children = children;
        // this.textAlign = align;

        arrangeChilderen();
    }

    // TableElement(IElement e) {
    //     this.id = e.getId();
    //     this.type = e.getType();
    //     this.position = e.getPosition();
    //     this.size = e.getSize();
    //     this.color = e.getColor();
    //     this.texture = e.getText();
    //     this.isDisabled = e.isDisabled();
    //     this.isHidden = e.isHidden();
    //     this.children = e.getChildren();
    //     this.listener = e.getMouseListener();
    //     this.textAlign = e.getAlign();
    // }

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

        for (RowElement child : this.children) {
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
    
    @Override
    public void renderComponent(Graphics g) {
        // nothing
    }

    public void setHeader(List<String> s) {
        header = new RowElement(s);
    }

    public void setColNumber(int n) {
        this.col = n;
    }

    public int getColNumber() {
        return this.col;
    }

    public void addRow(List<String> s) {
        children.add(new RowElement(s));
    }

    public void removeRow(int index) {
        children.remove(index);
    }

    public void removeRow() {
        removeRow(children.size()-1);
    }
}