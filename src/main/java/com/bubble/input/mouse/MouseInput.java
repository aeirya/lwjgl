package com.bubble.input.mouse;

import com.bubble.std.Dimension;
import com.bubble.std.Math;
import com.bubble.std.Point;
import com.bubble.ui.element.IElement;
import com.bubble.ui.management.IGuiManager;

public class MouseInput implements IMouseInputListener {
    private IElement currentElement;
    private IGuiManager gui;
    private IMouseListener externalListener;

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
        this.externalListener = listener;
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        if (gui != null) gui.clicked(findCurrentElement(mouse));
        if (externalListener != null) externalListener.onMouseClick(mouse);
        getMouseListener(mouse).onMouseClick(mouse);
    }

    public void onMouseRelease(MouseState mouse) {
        if (gui != null) gui.released(findCurrentElement(mouse));
        if (externalListener != null) externalListener.onMouseRelease(mouse);
        getMouseListener(mouse).onMouseRelease(mouse);
    }

    private IMouseListener getMouseListener(MouseState mouse) {
        currentElement = findCurrentElement(mouse);
        if (currentElement != null && currentElement.getMouseListener() != null) {
            System.out.println(currentElement.getId());
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
        if (externalListener != null) externalListener.onMouseMove(mouse);
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