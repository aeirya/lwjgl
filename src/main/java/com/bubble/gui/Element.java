package com.bubble.gui;

import java.util.List;

import com.bubble.input.IMouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class Element implements IElement {
    private String id;
    private ElementType type;
    private Point position;
    private Dimension size;
    private String text;
    private String font;
    private Color color;
    private String texture;
    private boolean isDisabled;
    private boolean isHidden;
    private IMouseListener listener;

    private List<Element> children;

    public Element() { }

    public Element(String id, ElementType type, Point position, Dimension size, String text, String font, Color color,
            String texture, boolean isDisabled, boolean isHidden, MouseEvent events, List<Element> children) {
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

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
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

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    public IMouseListener getMouseListener() {
        return listener;
    }

    public void setMouseListener(IMouseListener listener) {
        this.listener = listener;
    }

    public void paintComponent(IGuiRenderer r) {
        if (isHidden) return;
        if (type != null) {
            switch(type) {
                case BUTTON:
                r.drawButton(this);
                break;
                case PANEL:
                r.drawPanel(this);
                break;
                default:
                System.out.println("not rendering");
                break;
            }
        }
        if (children != null) {
            children.forEach(c -> c.paintComponent(r));
        }
    }
}