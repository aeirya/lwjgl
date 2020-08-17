package com.bubble.ui.element;

public enum ElementType {
    BUTTON, PANEL, LABEL, COLLIDER, TEXTBOX, IMAGE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
