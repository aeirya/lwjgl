package com.bubble.gui;

import java.util.List;

import com.bubble.render.IRenderer;

public interface IGuiRenderer extends IRenderer {
    void render(IElement element);
    void drawElement(IElement element);
    void drawButton(IElement button);
    void drawPanel(IElement e);

    void addElements(List<? extends IElement> list);
}