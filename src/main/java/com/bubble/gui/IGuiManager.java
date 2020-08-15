package com.bubble.gui;

import java.util.List;

import com.bubble.gui.element.IElement;
import com.bubble.input.GameInput;

public interface IGuiManager {
    List<IElement> getAllElementsOnScreen();
    void bind(GameInput input);
    void launch(IMenu menu);
    void clicked(IElement element);
}