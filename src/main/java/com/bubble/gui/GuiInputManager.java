package com.bubble.gui;

import java.util.List;

import com.bubble.gui.element.IElement;
import com.bubble.input.GameInput;

public class GuiInputManager implements IGuiManager {
    
    private final KeyInputRegisterer keyRegisterer;
    private IMenu currentMenu;
    private IElement active;

    public GuiInputManager() {
        keyRegisterer = new KeyInputRegisterer(this);
    }

    public void bind(GameInput input) {
        input.bindListener(keyRegisterer);
        input.bindGuiManager(this);
    }

    public void launch(IMenu menu) {
        this.currentMenu = menu;
    }

    public void setActive(IElement element) {
        active = element;
    }
    
    public void clicked(IElement element) {
        setActive(element);
    }

    public IElement getActiveElement() {
        return active;
    }

    public List<IElement> getAllElementsOnScreen() {
        return currentMenu.getLayout().findAllElements();
    }
}