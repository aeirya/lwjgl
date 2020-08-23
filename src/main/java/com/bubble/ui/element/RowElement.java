package com.bubble.ui.element;

import java.util.List;
import java.util.stream.Collectors;

import com.bubble.render.Graphics;
import com.bubble.tools.layout.ElementBuilder;

public class RowElement extends Element {
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
        // children.clear();
        // for (String c : this.content) {
        //     IElement e = new Element();
        //     e.setText(c);
        //     e.setFont(font);
        //     children.add(e);
        // }

        children = content.stream().map(str -> 
            new ElementBuilder().setText(str).setFont(font).toElement()
        ).map(e -> new RowEntity(e)).collect(Collectors.toList());
    }

    public List<IElement> getElement() {
        return children;
    }

    public IElement getElement(int index) {
        return children.get(index);
    }

    public void addElement(String s) {
        content.add(s);
        setElements();
    }

    public void addElement(IElement e) {
        children.add(e);
        content.add(e.getText());
    }

    @Override
    public void renderComponent(Graphics g) {
        // setElements();
        children.forEach(c -> c.renderComponent(g));
    }

    class RowEntity extends Element {

        RowEntity(IElement element) {
            super(element);
        }

        @Override
        public void renderComponent(Graphics g) {
            float scale = 0.0017f;
            g.drawText(text, position, scale);
        }
    }
}