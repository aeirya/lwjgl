package com.bubble.tools.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;

public class Layout {
    
    protected List<Element> elements;

    public Layout() {
        elements = new ArrayList<>();
    }

    public List<Element> getElementsByType(String type) {
        return elements.stream().filter(e -> e.type.equals(type)).collect(Collectors.toList());
    }

    public Element getElementById(String id) {
        return elements.stream().filter(e -> e.id.equals(id)).findFirst().orElse(null);
    }

    class Element {
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

        private List<Element> children;

        public Element(String id, String type, Dimension size, Position position, List<Element> children, String text) {
            this.id = id;
            this.type = type;
            this.size = size;
            this.position = position;
            this.children = children;
            this.text = text;
        }
    }

    class Dimension {
        private float width;
        private float height;

        public Dimension(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Color {
        private int r;
        private int g;
        private int b;
        private int a;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
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