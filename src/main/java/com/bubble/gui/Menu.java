package com.bubble.gui;

public class Menu {
    
    private final MenuLayout layout;

    public Menu() {
        layout = new MenuLayout("./assets/layout/main.json");
    }

    public void addTo(GuiRenderer gui) {
        gui.addElements(layout.getAllElements());
    }

}