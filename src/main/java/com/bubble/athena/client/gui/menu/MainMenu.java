package com.bubble.athena.client.gui.menu;

import com.bubble.athena.client.event.EventSystem;
import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class MainMenu extends Menu {
    
    public MainMenu(IMenuLauncher lnchr) {
        super("main.json", lnchr);
        new MainListenerMap().apply(this);
    }

    private class MainListenerMap extends MenuListenerMap {
        MainListenerMap() {
            listenerMap.put(
                "start_button", 
                new MouseListener()
                    .setOnClick(a -> {
                        System.out.println("clicked start");
                        EventSystem.push(h -> System.out.println("hi mate!"));
                        launch(MenuType.ARENA);
                        })
                    .setOnMove(a -> System.out.println("moooving to " + a.getPosition()))
                    .setOnMouseEnter(a -> System.out.println("enter!"))
                    .setOnMouseExit(a -> System.out.println("exit!")));
            listenerMap.put(
                "decks", 
                new MouseListener()
                    .setOnClick(a -> {
                        System.out.println("decksss");
                        launch(MenuType.DECKS);
                    })
                    .setOnMouseEnter(a -> System.out.println("hi"))
                    .setOnMouseExit(a -> System.out.println("bye")));
            listenerMap.put(
                "console",
                new MouseListener().setOnClick(a -> activeConsole())
                );
            listenerMap.put(
                "friends", 
                new MouseListener().setOnRelease(a -> launch(MenuType.FRIENDS))
                );
            listenerMap.put(
                "profile", 
                new MouseListener().setOnClick(a -> launch(MenuType.PROFILE))
                );
            listenerMap.put(
                "lobby", 
                new MouseListener().setOnClick(a -> launch(MenuType.LOBBY))
                );
        }

        private void activeConsole() {
            System.out.println("console!");
        }
    }
}