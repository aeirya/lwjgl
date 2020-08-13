package com.bubble.gui;

public enum ElementType {
    BUTTON, PANEL;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}