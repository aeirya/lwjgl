package com.bubble.tools.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.gui.Element;
import com.bubble.gui.ElementType;
import com.bubble.std.Point;
import com.bubble.util.file.FileLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Layout {
    
    protected List<LayoutElement> elements;

    public Layout() {
        elements = new ArrayList<>();
    }

    public List<LayoutElement> getElementsByType(String type) {
        return elements.stream().filter(e -> e.type.equals(type)).collect(Collectors.toList());
    }

    public LayoutElement getElementById(String id) {
        return elements.stream().filter(e -> e.id.equals(id)).findFirst().orElse(null);
    }

    private List<LayoutElement> getElements() {
        return elements;
    }

    public static List<Element> load(String path) {
        return new Gson()
        .fromJson(new Parser().parse(new FileLoader(path).load()), Layout.class)
        .getElements()
        .stream()
        .map(LayoutElement::toElement)
        .collect(Collectors.toList());
    }

    static class Parser {
        String parse(String json) {
            for (ElementType type : ElementType.values()) {
                final String q = "\"";
                final String swappable = q + type.toString() + q;
                json = json.replace(swappable, swappable.toUpperCase());
            }
            return json;
        }
    }

    class LayoutElement {
        private String id;
        private String type;
        private Position position;
        private Dimension size;
        private String text;
        private String font;
        private Color color;
        private String texture;
        private boolean isDisabled;
        private MouseEvent events;

        private List<LayoutElement> children;

        public LayoutElement(String id, String type, Dimension size, Position position, List<LayoutElement> children, String text) {
            this.id = id;
            this.type = type;
            this.size = size;
            this.position = position;
            this.children = children;
            this.text = text;
        }

        public Element toElement() {
            return new Element(
                id, 
                ElementType.valueOf(type), 
                getPosition(), 
                getDimension(), 
                text, 
                font, 
                getColor(), 
                texture, 
                isDisabled, 
                getMouseEvents(), 
                getChildren()
                );
        }

        private com.bubble.std.Color getColor() {
            if(color == null) return null;
            else return new com.bubble.std.Color(color.r, color.g, color.b, color.a);
        }

        private Point getPosition() {
            if (position == null) return null;
            else return new Point(position.x, position.y);
        }

        private com.bubble.std.Dimension getDimension() {
            if (size == null) return null;
            else return new com.bubble.std.Dimension(size.width, size.height);
        }
        
        private List<Element> getChildren() {
            if (children == null) return new ArrayList<>();
            else return children.stream().map(LayoutElement::toElement).collect(Collectors.toList());
        }

        // TODO: change this
        private com.bubble.gui.MouseEvent getMouseEvents() {
            return null;
        }
    }

    class Dimension {
        private float width;
        private float height;

        public Dimension(float width, float height) {
            this.width = width;
            this.height = height;
        }
    }

    class Position {
        private float x;
        private float y;

        public Position(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    class Color {
        private int r;
        private int g;
        private int b;
        private float a = 1.0f;

        public Color(int r, int g, int b, float a) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = 1.0f;
        }
    }

    class MouseEvent {
        private String onMouseEnter;
        private String onMouseExit;
        private String onMouseClick;
        private String onMouseUnclick;
        private String onMouseDrag;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}