package com.bubble.gui;

import java.util.List;

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
    private MouseEvent events;

    private List<Element> children;

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

    public MouseEvent getEvents() {
        return events;
    }

    public void setEvents(MouseEvent events) {
        this.events = events;
    }

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    public void paintComponent(IGuiRenderer r) {
        if (type != null) {
            switch(type) {
                case BUTTON:
                r.drawButton(this);
                // System.out.println("drawing button!");
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