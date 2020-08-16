package com.bubble.athena.client.gui.menu;

import com.bubble.gui.Menu;
import com.bubble.input.mouse.MenuListenerMap;

public class ArenaMenu extends Menu {

    public ArenaMenu() {
        super("game.json");
        new ArenaMenuListenerMap().apply(this);
    }

    private class ArenaMenuListenerMap extends MenuListenerMap {
        ArenaMenuListenerMap() {
            //     
        }
    }
    
}