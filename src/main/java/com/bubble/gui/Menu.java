package com.bubble.gui;

import com.bubble.gui.element.MenuLayout;
import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.util.config.Config;

public class Menu implements IMenu {

    private final MenuLayout layout;

    public Menu() {
        layout = new MenuLayout(Config.getLayoutPath() + "main.json");
        new MenuListenerMap(layout).apply();
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getElements());
    }

    public MenuLayout getLayout() {
        return layout;
    }
}