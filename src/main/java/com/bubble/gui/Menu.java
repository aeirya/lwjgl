package com.bubble.gui;

import com.bubble.input.IMouseInputListener;
import com.bubble.input.IMouseListener;
import com.bubble.input.IWindowInput;
import com.bubble.input.MenuListenerMap;
import com.bubble.input.MouseListener;
import com.bubble.input.MouseState;
import com.bubble.std.Dimension;
import com.bubble.std.Math;
import com.bubble.std.Point;

public class Menu implements IMouseInputListener {

    private static final String LAYOUT_PATH = "./assets/layout/main.json";
    private final MenuLayout layout;
    private final MouseListener listener;
    
    private Element currentElement;

    public Menu() {
        layout = new MenuLayout(LAYOUT_PATH);
        listener = new MouseListener();
        new MenuListenerMap().apply(layout);
    }

    public void listen(IWindowInput input) {
        input.setListener(this);
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getElements());
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        listener.onMouseMove(mouse);
        checkMouseExit(mouse);
    }

    private void onMouseExit(MouseState mouse) {
        if (currentElement == null) return;
        final IMouseListener mouseListener = currentElement.getMouseListener();
        if (mouseListener != null) mouseListener.onMouseExit(mouse);
    }

    private void checkMouseExit(MouseState mouse) {
        final Element e = getCurrentElement(mouse);
        if (e != null && e != currentElement) {
            onMouseExit(mouse);
            currentElement = e;
            onMouseEnter(mouse);
        }
    }

    private void onMouseEnter(MouseState mouse) {
        final IMouseListener mouseListener = currentElement.getMouseListener();
        if (mouseListener != null) {
            mouseListener.onMouseEnter(mouse);
        }
    }

    private Element getCurrentElement(MouseState mouse) {
        return layout
            .findAllElements()
            .parallelStream()
            .filter(e -> this.checkInRange(mouse, e))
            .sorted((a, b) -> a.getChildren().size() - b.getChildren().size())
            .findFirst()
            .orElse(null);
    }

    private IMouseListener getClickListener(MouseState mouse) {
        return getCurrentElement(mouse).getMouseListener();
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        final IMouseListener listener = getClickListener(mouse);
        if (listener != null) listener.onMouseClick(mouse);
    }

    private boolean checkInRange(MouseState mouse, Element element) {
        if (element == null) return false;
        final Point mousePos = mouse.getPosition();
        final Dimension size = element.getSize();
        final Point loc = element.getPosition();
        
        return checkX(mousePos, loc.x, size.width) &&
            checkY(mousePos, loc.y, size.height);
    }  

    private boolean checkX(Point location, float startX, float width) {
        return Math.checkInBound(location.getX(), startX, startX + width);
    }

    private boolean checkY(Point location, float startY, float height) {
        return Math.checkInBound(location.getY(), startY - height, startY);
    }

}