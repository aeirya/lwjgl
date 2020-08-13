package com.bubble.gui;

import com.bubble.render.IRenderer;

public interface IGuiRenderer extends IRenderer {
    void render(IElement element);
    void drawElement(IElement element);
    void drawButton(IButton button);
}