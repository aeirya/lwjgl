package com.bubble.gui;

import com.bubble.input.IMouseListener;
import com.bubble.input.IWindowInput;
import com.bubble.input.MenuListenerMap;
import com.bubble.input.MouseInputListener;
import com.bubble.input.MouseState;
import com.bubble.std.Dimension;
import com.bubble.std.Math;
import com.bubble.std.Point;

public class Menu implements IMouseListener {

    private static final String LAYOUT_PATH = "./assets/layout/main.json";
    private final MenuLayout layout;
    private final MouseInputListener listener;
    
    public Menu() {
        layout = new MenuLayout(LAYOUT_PATH);
        listener = new MouseInputListener();
        new MenuListenerMap().apply(layout, listener);
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
        Element currentElement = getCurrentElement(mouse);
        if(currentElement != null)
            System.out.println(currentElement.getType());
        else System.out.println("null");
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

    @Override
    public void onMouseClick(MouseState mouse) {
        listener.onMouseClick(mouse);
    }

    private boolean checkInRange(MouseState mouse, Element element) {
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