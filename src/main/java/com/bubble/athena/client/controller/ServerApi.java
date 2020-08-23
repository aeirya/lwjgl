package com.bubble.athena.client.controller;

import java.util.List;

public class ServerApi implements IFriendship {

    @Override
    public List<String> getGlobalChat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getUserChat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("sending to server: " + msg);

    }

    @Override
    public void sendMessage(String to, String msg) {
        // TODO Auto-generated method stub

    }
    
}