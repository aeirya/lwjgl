package com.bubble.gui;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.bubble.tools.layout.Layout;

public class MenuLayout {
    protected List<Element> elements;

    MenuLayout(String path) {
        elements = Layout.load(path);
    }

    public List<Element> getAllElements() {
        return elements;
    }

    public Element getElement(String id) {
        return elements.stream().filter(e -> e.getId() != null).filter(e -> e.getId().equals(id)).findAny().orElse(null);
    }

    public Element findInChildren(String id) {
        return findInChildren(id, elements);
    }

    private Element findInChildren(String id, List<Element> elements) {
        Element elem = elements.stream().filter(e -> e.getId() != null).filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if(elem != null) return elem;
        elem = elements
            .stream()
            .map(Element::getChildren)
            .filter(Objects::nonNull)
            .map(list -> findInChildren(id, list))
            .filter(Objects::nonNull)
            .findAny()
            .orElse(null);
        return elem;
    }

    public List<Element> getElementsOfType(ElementType type) {
        return elements.stream().filter(e -> e.getType().equals(type)).collect(Collectors.toList());
    }
}