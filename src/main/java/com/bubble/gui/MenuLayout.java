package com.bubble.gui;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bubble.tools.layout.Layout;

public class MenuLayout {
    protected List<Element> elements;

    public MenuLayout(String path) {
        elements = Layout.load(path);
    }

    public List<Element> getElements() {
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
            .orElse(Element.NULL);
        return elem;
    }

    public List<Element> getElementsOfType(ElementType type) {
        return elements.stream().filter(e -> e.getType().equals(type)).collect(Collectors.toList());
    }

    public List<Element> findAllElements() {
        return flattened().collect(Collectors.toList());
    }

    public Stream<Element> flattened() {
        return flattened(elements.get(0), elements.get(0).getChildren());
    }

    private Stream<Element> flattened(Element current, List<Element> children) {
        return Stream.concat(
            Stream.of(current), 
            children.stream().flatMap(e -> flattened(e, e.getChildren())));
    }
}