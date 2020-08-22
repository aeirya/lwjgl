package com.bubble.athena.client.gui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class LobbyMenu extends Menu {
    public LobbyMenu(IMenuLauncher lnchr) {
        super("lobby.json", lnchr);
        new LobbyListenerMap().apply(this);
    }

    private class LobbyListenerMap extends MenuListenerMap {
        LobbyListenerMap() {
            listenerMap.put(
                "back", 
                new MouseListener().setOnClick(a -> launch(MenuType.MAIN))
                );
        }
    }
}
