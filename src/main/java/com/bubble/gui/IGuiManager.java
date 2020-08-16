package com.bubble.gui;

import java.util.List;

import com.bubble.graphics.menu.MenuType;
import com.bubble.gui.card.legacy.ICardElement;
import com.bubble.gui.element.IElement;
import com.bubble.input.GameInput;

public interface IGuiManager {
    List<IElement> getAllElementsOnScreen();
    List<ICardElement> getPlayerHand();
    void bind(GameInput input);
    void launch(IMenu menu);
    void launch(MenuType menu);
    void clicked(IElement element);
}