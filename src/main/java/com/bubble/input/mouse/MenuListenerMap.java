package com.bubble.input.mouse;

import java.util.HashMap;
import java.util.Map;

import com.bubble.gui.MenuLayout;

public class MenuListenerMap {
    private final Map<String, IMouseListener> listenerMap;
    private final MenuLayout layout;

    public MenuListenerMap(MenuLayout layout) {
        this.layout = layout;
        listenerMap = new HashMap<>();
        listenerMap.put(
            "start_button", 
            new MouseListener()
                .setOnClick(a -> System.out.println("clicked start"))
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

    public void apply() {
        listenerMap.forEach((id, listener) -> {
            layout.findInChildren(id).setMouseListener(listener);
        });
    }

    private void activeConsole() {
        System.out.println("console!");
    }
}