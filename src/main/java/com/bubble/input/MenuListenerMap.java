package com.bubble.input;

import java.util.HashMap;
import java.util.Map;

import com.bubble.gui.MenuLayout;

public class MenuListenerMap {
    private final Map<String, IMouseListener> listenerMap;

    public MenuListenerMap() {
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
                
    }

    public void apply(MenuLayout layout) {
        listenerMap.forEach((id, listener) -> {
            layout.findInChildren(id).setMouseListener(listener);
        });
    }
}