package com.bubble.gui.element;

import java.util.List;
import java.util.stream.Collectors;

public class ElementConverer {
    private ElementConverer() { }

    public static IElement morph(IElement element) {
        if (! element.getChildren().isEmpty()) {
            element.setChildren(morph(element.getChildren()));
        }
        switch(element.getType()) {
            case TEXTBOX:
            return new Textbox(element);
            default:
            return element;
        }
    }

    public static List<IElement> morph(List<IElement> elements) {
        return elements.stream().map(ElementConverer::morph).collect(Collectors.toList());
    }
}