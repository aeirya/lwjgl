package com.bubble.gui;

import com.bubble.input.MenuListenerMap;

public class Menu implements IMenu {

    private static final String LAYOUT_PATH = "./assets/layout/main.json";
    private final MenuLayout layout;

    public Menu() {
        layout = new MenuLayout(LAYOUT_PATH);
        new MenuListenerMap().apply(layout);
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getElements());
    }

    public MenuLayout getLayout() {
        return layout;
    }
}