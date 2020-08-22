package com.bubble.input.keyboard;

public interface IKeyEvent {
    int getKey();
    KeyEventType getType();
    
    public enum KeyEventType {
        PRESS, RELEASE, HOLD
    }
}