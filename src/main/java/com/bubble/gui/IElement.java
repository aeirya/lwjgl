package com.bubble.gui;

import java.util.List;

import com.bubble.input.IMouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public interface IElement {
    String getId();
    ElementType getType();
    Point getPosition();
    Dimension getSize();
    String getText();
    Color getColor();
    String getFont();
    String getTexture();
    boolean isDisabled();
    boolean isHidden();
    void setMouseListener(IMouseListener listener);
    IMouseListener getMouseListener();
    List<Element> getChildren();
    void paintComponent(IGuiRenderer r);
}