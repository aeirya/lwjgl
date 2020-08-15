package com.bubble.gui;

import com.bubble.input.MenuListenerMap;
import com.bubble.util.config.Config;

public class Menu implements IMenu {

    private final MenuLayout layout;

    public Menu() {
        layout = new MenuLayout(Config.getLayoutPath() + "main.json");
        new MenuListenerMap().apply(layout);
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getElements());
    }

    public MenuLayout getLayout() {
        return layout;
    }
}