package com.bubble.tools.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.gui.Element;
import com.bubble.gui.ElementConverer;
import com.bubble.gui.ElementType;
import com.bubble.gui.IElement;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.util.file.FileLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Layout {
    
    protected List<LayoutElement> elements;

    public Layout() {
        elements = new ArrayList<>();
    }

    private List<LayoutElement> getElements() {
        return elements;
    }

    public static List<IElement> load(String path) {
        return new Gson()
        .fromJson(new FileLoader(path).load(), Layout.class)
        .getElements()
        .stream()
        .map(LayoutElement::toElement)
        .map(ElementConverer::morph)
        .collect(Collectors.toList());
    }

    class LayoutElement {
        private String id;
        private String type;
        private ElementPosition position;
        private ElementDimension size;
        private String text;
        private String font;
        private ElementColor color;
        private String texture;
        private boolean isHidden;
        private boolean isDisabled;

        private List<LayoutElement> children;

        public IElement toElement() {
            return new ElementBuilder()
                .setId(id)
                .setType(getType())
                .setPosition(getPosition())
                .setSize(getDimension())
                .setColor(getColor())
                .setText(text)
                .setFont(font)
                .setTexture(texture)
                .setDisabled(isDisabled)
                .setHidden(isHidden)
                .setChildren(getChildren())
                .toElement();
        }

        private ElementType getType() {
            return ElementType.valueOf(type.toUpperCase());
        }

        private Color getColor() {
            if(color == null) return null;
            else return new Color(color.r, color.g, color.b,  getAlpha());
        }

        private float getAlpha() {
            return (!isHidden && color.a == 0.0f) ? 1.0f : color.a;
        }

        private Point getPosition() {
            if (position == null) return null;
            else return new Point(position.x, position.y);
        }

        private Dimension getDimension() {
            if (size == null) return null;
            else return new Dimension(size.width, size.height);
        }
        
        private List<IElement> getChildren() {
            if (children == null) return new ArrayList<>();
            else return children.stream().map(LayoutElement::toElement).collect(Collectors.toList());
        }
    }

    protected class ElementDimension {
        private float width;
        private float height;
    }

    protected class ElementPosition {
        private float x;
        private float y;

        public ElementPosition(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    protected class ElementColor {
        private int r;
        private int g;
        private int b;
        private float a;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }


    /**
     * I have this idea where i can keep runnables of game api in a map, and 
     * even load events from there!
     * tho lots of performance will be lost
     */
    /**
    class MouseEvent {
        private String onMouseEnter;
        private String onMouseExit;
        private String onMouseClick;
        private String onMouseUnclick;
        private String onMouseDrag;
    }
    */
}