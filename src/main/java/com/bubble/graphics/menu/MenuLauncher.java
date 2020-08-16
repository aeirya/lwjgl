package com.bubble.graphics.menu;

import java.util.EnumMap;
import java.util.Map;

import com.bubble.gui.IMenu;

public abstract class MenuLauncher implements IMenuLauncher {
    protected final Map<MenuType, Class<? extends IMenu>> mapper;

    protected MenuLauncher() {
        mapper = new EnumMap<>(MenuType.class);
    }
    
    private Class<? extends IMenu> get(MenuType menuType) {
        return mapper.get(menuType);
    }

    public void launch(MenuType menu) {
        launch(get(menu));
    }

	protected abstract void launch(Class<? extends IMenu> menu);
}