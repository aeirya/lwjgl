package com.bubble.ui.element;

import java.util.List;

import com.bubble.font2.Font;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.render.Graphics;
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
    Font getFont();
    Align getAlign();
    String getTexture();
    boolean isDisabled();
    boolean isHidden();
    IMouseListener getMouseListener();
    List<IElement> getChildren();
    
    void setText(String text);
    void setChildren(List<IElement> children);
    void setPosition(Point position);

    void setMouseListener(IMouseListener listener);
    void renderComponent(Graphics g);
}