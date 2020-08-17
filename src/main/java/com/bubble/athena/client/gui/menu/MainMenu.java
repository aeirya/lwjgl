package com.bubble.athena.client.gui.menu;

import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.Menu;

public class MainMenu extends Menu {
    
    public MainMenu() {
        super("main.json");
        new MainListenerMap().apply(this);
    }

    private class MainListenerMap extends MenuListenerMap {
        MainListenerMap() {
            listenerMap.put(
                "start_button", 
                new MouseListener()
                    .setOnClick(a -> {
                        System.out.println("clicked start");
                        })
                    .setOnMove(a -> System.out.println("moooving to " + a.getPosition()))
                    .setOnMouseEnter(a -> System.out.println("enter!"))
                    .setOnMouseExit(a -> System.out.println("exit!")));
            listenerMap.put(
                "decks", 
                new MouseListener()
                    .setOnClick(a -> System.out.println("decksss"))
                    .setOnMouseEnter(a -> System.out.println("hi"))
                    .setOnMouseExit(a -> System.out.println("bye")));
            listenerMap.put(
                "console",
                new MouseListener().setOnClick(a -> activeConsole())
                );                
        }

        private void activeConsole() {
            System.out.println("console!");
        }
    }
}