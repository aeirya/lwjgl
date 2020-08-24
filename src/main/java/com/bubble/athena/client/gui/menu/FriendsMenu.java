package com.bubble.athena.client.gui.menu;

import com.bubble.athena.client.controller.IFriendship;
import com.bubble.athena.client.controller.Network;
import com.bubble.athena.client.controller.ServerApi;
import com.bubble.athena.client.event.EventSystem;
import com.bubble.input.mouse.MenuListenerMap;
import com.bubble.input.mouse.MouseListener;
import com.bubble.ui.element.ITextbox;
import com.bubble.ui.menu.IMenuLauncher;
import com.bubble.ui.menu.Menu;
import com.bubble.ui.menu.MenuType;

public class FriendsMenu extends Menu {
    
    private IFriendship friendship;

    public FriendsMenu(IMenuLauncher lnchr) {
        super("overlay.json", lnchr);
        friendship = Network.getApi();
        new FriendsListenerMap().apply(this);
    }

    private class FriendsListenerMap extends MenuListenerMap {
        FriendsListenerMap() {
            listenerMap.put(
                "back", 
                new MouseListener().setOnClick(a -> launch(MenuType.MAIN))
                );
            listenerMap.put(
                "text_box",
                new MouseListener().setOnClick(a -> activeTextBox())
                );
            listenerMap.put(
                "send",
                new MouseListener().setOnClick(a -> sendMessage())
                );
        }

        private void sendMessage() {
            final String message = getMessage();
            if (message != null && ! message.equals("")) {
                friendship.sendMessage(getMessage());
                getMessageTextbox().clear();
            }
        }

        private ITextbox getMessageTextbox() {
            return (ITextbox) getElement("message_textbox");
        }
        
        private String getMessage() {
            return getMessageTextbox().getText();
        }

        private Object activeTextBox() {
            System.out.println("talking from the mapper");
            return null;
        }
    }
}