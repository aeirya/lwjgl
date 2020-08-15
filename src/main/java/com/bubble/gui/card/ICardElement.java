package com.bubble.gui.card;

import com.bubble.gui.IGuiRenderer;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public interface ICardElement {
    String getId();
    CardType getType();
    Point getPosition();
    Dimension getSize();
    String getText();
    Color getColor();
    String getFont();
    String getTexture();
    IMouseListener getMouseListener();

    void setText(String text);
    void setMouseListener(IMouseListener listener);
    void paintComponent(IGuiRenderer r);
}