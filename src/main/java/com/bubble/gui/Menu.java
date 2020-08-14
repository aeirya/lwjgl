package com.bubble.gui;

import com.bubble.input.IMouseListener;
import com.bubble.input.IWindowInput;
import com.bubble.input.MenuListenerMap;
import com.bubble.input.MouseInputListener;
import com.bubble.input.MouseState;

public class Menu implements IMouseListener {

    private static final String LAYOUT_PATH = "./assets/layout/main.json";
    private final MenuLayout layout;
    private final MouseInputListener listener;

    public Menu() {
        layout = new MenuLayout(LAYOUT_PATH);
        listener = new MouseInputListener();
        new MenuListenerMap().apply(layout, listener);
    }

    public void listen(IWindowInput input) {
        input.setListener(this);
    }

    public void addTo(IGuiRenderer gui) {
        gui.addElements(layout.getAllElements());
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        listener.onMouseMove(mouse);
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        listener.onMouseClick(mouse);
    }

}