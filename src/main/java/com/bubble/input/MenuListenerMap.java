package com.bubble.input;

import java.util.HashMap;
import java.util.Map;

import com.bubble.gui.MenuLayout;

public class MenuListenerMap {
    private final Map<String, IMouseListener> listenerMap;

    public MenuListenerMap() {
        listenerMap = new HashMap<>();
        listenerMap.put("start_button", new MouseInputListener().setOnClick(a -> System.out.println("clicked start")).setOnMove(a -> System.out.println("moooving to " + a.getPosition())));
    }

    public void apply(MenuLayout layout, IMouseEventDispatcher menu) {
        listenerMap.forEach((id, listener) -> {
            layout.findInChildren(id).setMouseListener(listener);
            menu.addListener(listener);
        });
    }
}