package com.bubble.input.mouse;

import java.util.HashMap;
import java.util.Map;

import com.bubble.gui.IMenu;
import com.bubble.gui.element.MenuLayout;

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