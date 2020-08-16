package com.bubble.athena.client.gui.menu;

import java.lang.reflect.InvocationTargetException;

import com.bubble.graphics.menu.MenuLauncher;
import com.bubble.graphics.menu.MenuType;
import com.bubble.gui.IGuiManager;
import com.bubble.gui.IMenu;

public class GameMenuLauncher extends MenuLauncher {
    private IGuiManager gui;

    public GameMenuLauncher(IGuiManager gui) {
        super();
        init();
        this.gui = gui;
    }

    private void init() {
        mapper.put(MenuType.MAIN, MainMenu.class);
        mapper.put(MenuType.ARENA, ArenaMenu.class);
    }

    @Override
    protected void launch(Class<? extends IMenu> clazz) {
        final IMenu menu = make(clazz);
        if (menu != null) gui.launch(menu);
    }

    private IMenu make(Class<? extends IMenu> menu) {
        try {
            return menu.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

}