package com.bubble.ui.menu;

import java.util.List;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.ui.element.IElement;
import com.bubble.util.config.Config;

public class Menu implements IMenu {

    private final MenuLayout layout;
    private final IMenuLauncher launcher;
    private final List<IElement> elements;

    protected Menu(String layoutName, IMenuLauncher launcher) {
        this.layout = new MenuLayout(Config.getLayoutPath() + layoutName);
        new MenuListenerMap().apply(layout);
        this.launcher = launcher;
        elements = layout.findAllElements();
    }

    protected void launch(MenuType menu) {
        launcher.launch(menu);
    }

    public List<IElement> getAllElementsOnScreen() {
        return elements;
    }

    public MenuLayout getLayout() {
        return layout;
    }
}