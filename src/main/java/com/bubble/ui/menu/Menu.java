package com.bubble.ui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.util.config.Config;

public class Menu implements IMenu {

    private final MenuLayout layout;
    private final IMenuLauncher launcher;

    protected Menu(String layoutName, IMenuLauncher launcher) {
        this.layout = new MenuLayout(Config.getLayoutPath() + layoutName);
        new MenuListenerMap().apply(layout);
        this.launcher = launcher;
    }

    protected void launch(MenuType menu) {
        launcher.launch(menu);
    }

    public MenuLayout getLayout() {
        return layout;
    }
}