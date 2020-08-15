package com.bubble.tools.layout;

import java.util.List;

import com.bubble.gui.element.Element;
import com.bubble.gui.element.ElementType;
import com.bubble.gui.element.IElement;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class ElementBuilder {
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

    private List<IElement> children;

    public ElementBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ElementBuilder setType(ElementType type) {
        this.type = type;
        return this;
    }

    public ElementBuilder setPosition(Point position) {
        this.position = position;
        return this;
    }

    public ElementBuilder setSize(Dimension size) {
        this.size = size;
        return this;
    }

    public ElementBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ElementBuilder setFont(String font) {
        this.font = font;
        return this;
    }

    public ElementBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public ElementBuilder setTexture(String texture) {
        this.texture = texture;
        return this;
    }

    public ElementBuilder setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    public ElementBuilder setHidden(boolean isHidden) {
        this.isHidden = isHidden;
        return this;
    }

    public ElementBuilder setChildren(List<IElement> children) {
        this.children = children;
        return this;
    }

    public IElement toElement() {
        return new Element(id, type, position, size, text, font, color, texture, isDisabled, isHidden, children);
    }
}