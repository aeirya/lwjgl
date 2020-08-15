package com.bubble.gui;

import java.util.List;

import com.bubble.gui.element.IElement;
import com.bubble.render.Graphics;
import com.bubble.render.IRenderer;
import com.bubble.std.Point;

public interface IGuiRenderer extends IRenderer {
    void render(IElement element);
    void drawElement(IElement element);
    void drawButton(IElement button);
    void drawPanel(IElement e);
	void drawText(String text, Point position, String font);

    void addElements(List<? extends IElement> list);

    Graphics getGraphics();
}