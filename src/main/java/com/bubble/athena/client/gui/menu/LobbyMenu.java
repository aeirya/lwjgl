package com.bubble.athena.client.gui.menu;

import java.util.Arrays;
import java.util.List;

import com.bubble.font2.Font;
import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.ui.element.TableElement;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class LobbyMenu extends Menu {
    public LobbyMenu(IMenuLauncher lnchr) {
        super("lobby.json", lnchr);
        new LobbyListenerMap().apply(this);
        setupTable();
    }
    
    private void setupTable() {
        TableElement table = new TableElement("table", new Point(0, 0), new Dimension(1, 1), Font.GRAND_HOTEL_REGULAR, new Color(1, 1, 1));
        table.setHeader(List.of("header1", "header2"));
        table.addRow(List.of("aeirya", "ali"));
        getElement("main_panel").addElemenet(table);
        // addElement(table);
    }

    private class LobbyListenerMap extends MenuListenerMap {
        LobbyListenerMap() {
            listenerMap.put(
                "back", 
                new MouseListener().setOnClick(a -> launch(MenuType.MAIN))
                );
        }
    }
}
