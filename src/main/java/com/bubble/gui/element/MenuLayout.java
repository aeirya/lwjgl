package com.bubble.gui.element;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bubble.tools.layout.Layout;

public class MenuLayout {
    protected List<IElement> elements;

    public MenuLayout(String path) {
        elements = Layout.load(path);
    }

    public List<IElement> getElements() {
        return elements;
    }

    public IElement getElement(String id) {
        return elements.stream().filter(e -> e.getId() != null).filter(e -> e.getId().equals(id)).findAny().orElse(null);
    }

    public IElement findInChildren(String id) {
        return findInChildren(id, elements);
    }

    private IElement findInChildren(String id, List<IElement> elements) {
        IElement elem = elements.stream().filter(e -> e.getId() != null).filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if(elem != null) return elem;
        elem = elements
            .stream()
            .map(IElement::getChildren)
            .filter(Objects::nonNull)
            .map(list -> findInChildren(id, list))
            .filter(Objects::nonNull)
            .findAny()
            .orElse(Element.NULL);
        return elem;
    }

    public List<IElement> getElementsOfType(ElementType type) {
        return elements.stream().filter(e -> e.getType().equals(type)).collect(Collectors.toList());
    }

    public List<IElement> findAllElements() {
        return flattened().collect(Collectors.toList());
    }

    public Stream<IElement> flattened() {
        return flattened(elements.get(0), elements.get(0).getChildren());
    }

    private Stream<IElement> flattened(IElement current, List<IElement> children) {
        return Stream.concat(
            Stream.of(current), 
            children.stream().flatMap(e -> flattened(e, e.getChildren())));
    }
}