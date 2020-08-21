package com.bubble.athena.client.gui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class FriendsMenu extends Menu {
    public FriendsMenu(IMenuLauncher lnchr) {
        super("overlay.json", lnchr);
        new FriendsListenerMap().apply(this);
    }

    private class FriendsListenerMap extends MenuListenerMap {
        FriendsListenerMap() {
            listenerMap.put(
                "back", 
                new MouseListener().setOnClick(a -> launch(MenuType.MAIN))
                );
            listenerMap.put(
                "text_box",
                new MouseListener().setOnClick(a -> activeTextBox())
                );
            listenerMap.put(
                "send",
                new MouseListener().setOnClick(a -> sendMessage())
                );
        }

        private Object sendMessage() {
            return null;
        }

        private Object activeTextBox() {
            System.out.println("talking from the mapper");
            return null;
        }
    }
}