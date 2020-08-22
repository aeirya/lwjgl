package com.bubble.athena.client.gui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class DeckMenu extends Menu {

    public DeckMenu(IMenuLauncher launcher) {
        super("decks.json", launcher);
        new ProfileListenerMap().apply(this);
    }
    
    private class ProfileListenerMap extends MenuListenerMap {
        ProfileListenerMap() {
            listenerMap.put(
                "back", 
                new MouseListener().setOnClick(a -> launch(MenuType.MAIN))
                );
        }
    }
}