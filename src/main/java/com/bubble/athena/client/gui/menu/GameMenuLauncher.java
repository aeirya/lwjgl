package com.bubble.athena.client.gui.menu;

import java.lang.reflect.InvocationTargetException;

import com.bubble.ui.management.IGuiManager;
import com.bubble.ui.menu.IMenu;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.MenuLauncher;
import com.bubble.ui.menu.MenuType;

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
        mapper.put(MenuType.FRIENDS, FriendsMenu.class);
        mapper.put(MenuType.PROFILE, ProfileMenu.class);
        mapper.put(MenuType.DECKS, DeckMenu.class);
        mapper.put(MenuType.LOBBY, LobbyMenu.class);
    }

    @Override
    protected void launch(Class<? extends IMenu> clazz) {
        final IMenu menu = make(clazz);
        if (menu != null) gui.launch(menu);
    }

    private IMenu make(Class<? extends IMenu> menu) {
        try {
            return menu.getConstructor(IMenuLauncher.class).newInstance(this);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

}