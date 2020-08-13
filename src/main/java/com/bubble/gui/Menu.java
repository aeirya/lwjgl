package com.bubble.gui;

public class Menu {
    
    private final MenuLayout layout;
    private static final String LAYOUT_PATH = "./assets/layout/main.json";

    public Menu() {
        layout = new MenuLayout(LAYOUT_PATH);
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getAllElements());
    }
}