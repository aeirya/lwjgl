package com.bubble.graphics;

import java.util.List;

import com.bubble.athena.client.gui.menu.GameMenuLauncher;
import com.bubble.graphics.menu.IMenuLauncher;
import com.bubble.graphics.menu.MenuType;
import com.bubble.gui.GuiInputManager;
import com.bubble.gui.IGuiManager;
import com.bubble.gui.IMenu;
import com.bubble.gui.card.legacy.Card;
import com.bubble.gui.card.legacy.CardElement;
import com.bubble.gui.card.legacy.GuiElement;
import com.bubble.gui.card.legacy.ICardElement;
import com.bubble.gui.element.IElement;
import com.bubble.input.GameInput;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class GuiManager implements IGuiManager {
    private final GuiInputManager inputManager;
    private final IMenuLauncher launcher; 
    private IMenu currentMenu;

    public GuiManager() {
        inputManager = new GuiInputManager(this);
        launcher = new GameMenuLauncher(this);
    }

    @Override
    public List<IElement> getAllElementsOnScreen() {
        return currentMenu.getLayout().findAllElements();
    }

    @Override
    public void bind(GameInput input) {
        input.bindGuiManager(this);
        inputManager.bind(input);
    }

    public void launch(MenuType menu) {
        launcher.launch(menu);
    }

    @Override
    public void launch(IMenu menu) {
        this.currentMenu = menu;
    }

    private void setMenu(IMenu menu) {
        this.currentMenu = menu;
    }

    @Override
    public void clicked(IElement element) {
        inputManager.clicked(element);
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
