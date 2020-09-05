package com.bubble.ui.management;

import java.util.List;

import com.bubble.athena.client.gui.menu.GameMenuLauncher;
import com.bubble.input.IGameInput;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.ui.card.legacy.Card;
import com.bubble.ui.card.legacy.CardElement;
import com.bubble.ui.card.legacy.GuiElement;
import com.bubble.ui.card.legacy.ICardElement;
import com.bubble.ui.element.IElement;
import com.bubble.ui.menu.IMenu;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.MenuType;

public class GuiManager implements IGuiManager {
    private final GuiInputManager inputManager;
    private final IMenuLauncher launcher; 
    private IMenu currentMenu;

    public GuiManager() {
        inputManager = new GuiInputManager(this);
        launcher = new GameMenuLauncher(this);
    }

    @Override
    public void bind(IGameInput input) {
        input.provideGuiManager(this);
        inputManager.bind(input);
    }

    @Override
    public List<IElement> getAllElementsOnScreen() {
        return currentMenu.getAllElementsOnScreen();
    }

    public void launch(MenuType menu) {
        launcher.launch(menu);
    }

    @Override
    public void launch(IMenu menu) {
        this.currentMenu = menu;
    }

    @Override
    public void clicked(IElement element) {
        inputManager.clicked(element);
    }

    @Override
    public void released(IElement element) {
        inputManager.released(element);
    }

    @Override
    public List<ICardElement> getPlayerHand() {
        return List.of(
            new CardElement(
                new GuiElement(
                    new Point(0, 0),
                    new Dimension(0.3f, 0.6f)
                    ),
                new Card("bear")
                )
        );
    }
}
