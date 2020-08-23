package com.bubble.ui.element;

import java.util.List;

import com.bubble.font2.Font;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.render.Graphics;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.tools.debug.LoudMouseAdaptor;

public class Element implements IElement {
    protected String id;
    protected ElementType type;
    protected Point position;
    protected Dimension size;
    protected String text;
    protected Font font;
    protected Color color;
    protected String texture;
    protected Align textAlign;
    protected boolean isDisabled;
    protected boolean isHidden;
    protected IMouseListener listener;
    protected List<IElement> children;

    public Element() { }

    public Element(String id, ElementType type, Point position, Dimension size, String text, Font font, Align align, Color color,
            String texture, boolean isDisabled, boolean isHidden, List<IElement> children) {
        this.id = id;
        this.type = type;
        this.position = position;
        this.size = size;
        this.text = text;
        this.font = font;
        this.color = color;
        this.texture = texture;
        this.isDisabled = isDisabled;
        this.isHidden = isHidden;
        this.children = children;
    }

    public Element(IElement e) {
        this.id = e.getId();
        this.type = e.getType();
        this.position = e.getPosition();
        size = e.getSize();
        text = e.getText();
        textAlign = e.getAlign();
        font = e.getFont();
        color = e.getColor();
        texture = e.getText();
        isDisabled = e.isDisabled();
        isHidden = e.isHidden();
        children = e.getChildren();
        listener = e.getMouseListener();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public void setAlign(Align align) {
        this.textAlign = align;
    }

    public Align getAlign() {
        return textAlign;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public List<IElement> getChildren() {
        return children;
    }

    public void setChildren(List<IElement> children) {
        this.children = children;
    }

    public IMouseListener getMouseListener() {
        return listener;
    }

    public void setMouseListener(IMouseListener listener) {
        this.listener = listener;
    }

    @Override
    public void renderComponent(Graphics g) {
        // nothing
    }

    public static final Element NULL = new Element() {
        @Override
        public IMouseListener getMouseListener() {
            return new LoudMouseAdaptor("null element");
        }
    };
}