package com.bubble.tools.layout;

import java.util.List;
import java.util.stream.Collectors;

import com.bubble.ui.element.Button;
import com.bubble.ui.element.IElement;
import com.bubble.ui.element.TextArea;
import com.bubble.ui.element.Textbox;

public class ElementConverer {
    private ElementConverer() { }

    public static IElement morph(IElement element) {
        if (! element.getChildren().isEmpty()) {
            element.setChildren(morph(element.getChildren()));
        }
        switch(element.getType()) {
            case TEXTBOX:
            return new Textbox(element);
            case TEXT_AREA:
            return new TextArea(element);
            case BUTTON:
            return new Button(element);
            default:
            return element;
        }
    }

    public static List<IElement> morph(List<IElement> elements) {
        return elements.stream().map(ElementConverer::morph).collect(Collectors.toList());
    }
}