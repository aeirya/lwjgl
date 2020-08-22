package com.bubble.ui.element;

import java.util.List;

public class RowElement extends Element {
    private List<IElement> elements;
    private List<String> content;

    RowElement() { }

    RowElement(final List<String> content) {
        this.content = content;
        setElements();
    }

    RowElement(final String[] content) {
        for (final String item : content) this.content.add(item);
        setElements();
    }

    private void setElements() {
        elements.clear();
        for (String c : this.content) {
            IElement e = new Element();
            e.setText(c);
            elements.add(e);
        }
    }

    public List<IElement> getElement() {
        return elements;
    }

    public IElement getElement(int index) {
        return elements.get(index);
    }

    public void addElement(String s) {
        content.add(s);
        setElements();
    }

    public void addElement(IElement e) {
        elements.add(e);
        content.add(e.getText());
    }
}