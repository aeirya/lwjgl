package com.bubble.input.keyboard;

public class KeyListener implements IKeyListener {

    @Override
    public void onKeyPress(IKeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onKeyRelease(IKeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onKeyHold(IKeyEvent event) {
        System.out.println("holding " + event.getKey());
    }

    @Override
    public void onCharCallback(int codepoint) {
        System.out.println("typing: " + codepoint);
    }
    
}