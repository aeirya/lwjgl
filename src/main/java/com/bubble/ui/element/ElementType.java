package com.bubble.ui.element;

public enum ElementType {
    BUTTON, PANEL, LABEL, COLLIDER, TEXTBOX, TEXT_AREA, IMAGE, TABLE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
