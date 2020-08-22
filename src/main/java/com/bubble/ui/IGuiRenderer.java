package com.bubble.ui;

import java.util.List;

import com.bubble.render.IRenderer;
import com.bubble.ui.element.IElement;

public interface IGuiRenderer extends IRenderer {
    void render(IElement element);
    void drawElement(IElement element);
    void drawButton(IElement button);
    void drawPanel(IElement e);
    
    void render(List<IElement> elements);
}