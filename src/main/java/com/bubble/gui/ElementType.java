package com.bubble.gui;

public enum ElementType {
    BUTTON, PANEL, LABEL, COLLIDER, TEXTBOX;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}