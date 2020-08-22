package com.bubble.athena.client.gui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class ArenaMenu extends Menu {

    public ArenaMenu(IMenuLauncher lnchr) {
        super("game.json", lnchr);
        new ArenaMenuListenerMap().apply(this);
    }

    private class ArenaMenuListenerMap extends MenuListenerMap {
        ArenaMenuListenerMap() {
            listenerMap.put(
                "friends_button", 
                new MouseListener()
                    .setOnClick(
                        e -> launch(MenuType.MAIN)
                    ));
        }
    }
    
}