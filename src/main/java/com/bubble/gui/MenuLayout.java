package com.bubble.gui;

import java.util.List;

import com.bubble.tools.layout.Layout;
public class MenuLayout {
    protected List<Element> elements;

    MenuLayout(String path) {
        elements = Layout.load(path);
    }

    public List<Element> getAllElements() {
        return elements;
    }
}