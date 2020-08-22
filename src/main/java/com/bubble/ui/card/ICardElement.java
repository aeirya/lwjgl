package com.bubble.ui.card;

import com.bubble.input.mouse.IMouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.ui.IGuiRenderer;

public interface ICardElement {
    String getName();
    CardType getType();
    Point getPosition();
    Dimension getSize();
    String getDescription();
    Color getColor();
    String getFont();
    String getTexture();
    IMouseListener getMouseListener();

    void setText(String text);
    void setMouseListener(IMouseListener listener);
    void paintComponent(IGuiRenderer r);
}