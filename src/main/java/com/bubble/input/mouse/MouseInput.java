package com.bubble.input.mouse;

import com.bubble.gui.IGuiManager;
import com.bubble.gui.element.IElement;
import com.bubble.std.Dimension;
import com.bubble.std.Math;
import com.bubble.std.Point;

public class MouseInput implements IMouseInputListener {
    private IElement currentElement;
    private IGuiManager gui;
    private IMouseListener listener;

    public MouseInput(IWindowInput window) {
        listen(window);
    }

    public void setGuiManager(IGuiManager gui) {
        this.gui = gui;
    }

    public void listen(IWindowInput input) {
        input.setListener(this);
    }

    public void setListener(IMouseListener listener) {
        this.listener = listener;
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        // if (gui != null) gui.onMouseClick(mouse);
        getMouseListener().onMouseClick(mouse);
        if (gui != null) gui.clicked(findCurrentElement(mouse));
    }

    public void onMouseRelease(MouseState mouse) {
        // if (gui != null) gui.onMouseRelease(mouse);
        getMouseListener().onMouseRelease(mouse);
    }

    private IMouseListener getMouseListener() {
        if (currentElement != null && currentElement.getMouseListener() != null) {
            return currentElement.getMouseListener();
        } 
        else return new IMouseAdapter(){ };
    }

    public IElement findCurrentElement(MouseState state) {
        if (gui == null) {
            return null;
        }
        return gui
            .getAllElementsOnScreen()
            .parallelStream()
            .filter(e -> checkInRange(state.getPosition(), e))
            .sorted((a, b) -> a.getChildren().size() - b.getChildren().size())
            .findFirst()
            .orElse(null);
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        // if (gui != null) gui.onMouseMove(mouse);
        checkMouseExit(mouse);
    }
    
    private void checkMouseExit(MouseState mouse) {
        final IElement e = findCurrentElement(mouse);
        if (e != null && e != currentElement) {
            onMouseExit(mouse);
            currentElement = e;
            onMouseEnter(mouse);
        }
    }
    
    private void onMouseExit(MouseState mouse) {
        if (currentElement == null) return;
        final IMouseListener mouseListener = currentElement.getMouseListener();
        if (mouseListener != null) mouseListener.onMouseExit(mouse);
    }

    private void onMouseEnter(MouseState mouse) {
        final IMouseListener mouseListener = currentElement.getMouseListener();
        if (mouseListener != null) {
            mouseListener.onMouseEnter(mouse);
        }
    }
    
    // checks mouse boundary

    public boolean checkInRange(Point mousePos, IElement element) {
        if (element == null) return false;
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