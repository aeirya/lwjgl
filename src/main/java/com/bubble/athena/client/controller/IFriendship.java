package com.bubble.athena.client.controller;

import java.util.List;

public interface IFriendship {
    
    List<String> getGlobalChat();
    List<String> getUserChat();
    String getUsername();

    void sendMessage(String msg);
    void sendMessage(String to, String msg);

}