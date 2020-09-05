package com.bubble.ui.management;

import java.util.List;

import com.bubble.input.IGameInput;
import com.bubble.ui.card.legacy.ICardElement;
import com.bubble.ui.element.IElement;
import com.bubble.ui.menu.IMenu;
import com.bubble.ui.menu.MenuType;

public interface IGuiManager {
    List<IElement> getAllElementsOnScreen();
    List<ICardElement> getPlayerHand();

    void bind(IGameInput input);
    
    void clicked(IElement element);
    void released(IElement element);
    
    void launch(IMenu menu);
    void launch(MenuType menu);
}