package com.bubble.gui;

import java.util.List;

import com.bubble.input.mouse.IMouseListener;
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
    IMouseListener getMouseListener();
    List<IElement> getChildren();
    
    void setText(String text);
    void setChildren(List<IElement> children);
    void addText(String text);
    
    void setMouseListener(IMouseListener listener);
    void paintComponent(IGuiRenderer r);
}