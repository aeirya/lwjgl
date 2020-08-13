package com.bubble.gui;

import java.util.ArrayList;
import java.util.List;

import com.bubble.render.Graphics;

public class GuiRenderer implements IGuiRenderer {
    private final Graphics g;
    private List<IElement> elements;

    public GuiRenderer() {
        g = new Graphics();
        elements = new ArrayList<>();
    }

    public void addElement(IElement e) {
        elements.add(e);
    }

    public void addElements(List <? extends IElement> e) {
        elements.addAll(e);
    }

    public void removeElement(IElement e) {
        elements.remove(e);
    }

    @Override
    public void drawElement(IElement element) {
        element.paintComponent(this);
    }

    public void drawButton(IElement button) {
        g.drawRect(button.getPosition(), button.getSize(), button.getColor());
    }

    public void drawPanel(IElement e) {
        g.drawRect(e.getPosition(), e.getSize(), e.getColor());
    }

    public void render(IElement element) {
        drawElement(convert(element));
    }

    private IElement convert(IElement element) {
        return element; // i guess we don't need that :))
    }

    private void clear() {
        g.clear();
    }

    public void render() {
        clear();
        elements.forEach(this::render);
        g.render();
    }
}