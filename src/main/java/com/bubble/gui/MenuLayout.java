package com.bubble.gui;

import java.util.ArrayList;
import java.util.List;

import com.bubble.util.file.FileLoader;
import com.google.gson.GsonBuilder;

public class MenuLayout {
    protected List<Element> elements;

    MenuLayout() {
        elements = new ArrayList<>();
    }

    public List<Element> getAllElements() {
        return elements;
    }

    static MenuLayout load(String path) {
        return new GsonBuilder()
            .create()
            .fromJson(
                new Parser().parse(new FileLoader(path).load()),
                MenuLayout.class);
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
}