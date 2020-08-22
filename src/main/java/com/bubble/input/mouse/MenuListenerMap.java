package com.bubble.input.mouse;

import java.util.HashMap;
import java.util.Map;

import com.bubble.ui.menu.IMenu;
import com.bubble.ui.menu.MenuLayout;

public class MenuListenerMap {
    protected final Map<String, IMouseListener> listenerMap;

    public MenuListenerMap() {
        listenerMap = new HashMap<>();
    }

    public void apply(MenuLayout layout) {
        listenerMap.forEach((id, listener) -> {
            layout.findInChildren(id).setMouseListener(listener);
        });
    }

    public void apply(IMenu menu) {
        apply(menu.getLayout());
    }
}