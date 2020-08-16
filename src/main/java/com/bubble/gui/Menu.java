package com.bubble.gui;

import com.bubble.gui.element.MenuLayout;
import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.util.config.Config;

public class Menu implements IMenu {

    private final MenuLayout layout;

    protected Menu(String layoutName) {
        this.layout = new MenuLayout(Config.getLayoutPath() + layoutName);
        new MenuListenerMap().apply(layout);
    }

    public MenuLayout getLayout() {
        return layout;
    }
}