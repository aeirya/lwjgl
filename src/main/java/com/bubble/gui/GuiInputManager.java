package com.bubble.gui;

import java.util.List;

import com.bubble.gui.element.IElement;
import com.bubble.input.GameInput;

public class GuiInputManager {
    
    private final IGuiManager gui;
    private final KeyInputRegisterer keyRegisterer;
    private IElement active;

    public GuiInputManager(IGuiManager gui) {
        this.gui = gui;
        keyRegisterer = new KeyInputRegisterer(this);
    }

    public void bind(GameInput input) {
        input.bindListener(keyRegisterer);
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
        return gui.getAllElementsOnScreen();
    }
}