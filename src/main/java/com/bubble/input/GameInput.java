package com.bubble.input;

import com.bubble.gui.IMenu;
import com.bubble.input.keyboard.IKeyListener;
import com.bubble.input.keyboard.KeyboardInput;
import com.bubble.input.mouse.IMouseInputListener;
import com.bubble.input.mouse.IWindowInput;
import com.bubble.input.mouse.MouseInput;

public class GameInput implements IGameInput {

    private MouseInput mouse;
    private IKeyListener keyboard;
    private IWindowInput window;

    public GameInput(IWindowInput window) {
        mouse = new MouseInput(window);
        keyboard = new KeyboardInput(window);
    }

    public void setListener(MouseInput listener) {
        this.mouse = listener;
        bind(window);
    }

    public void setListener(IKeyListener listener) {
        this.keyboard = listener;
        bind(window);
    }

    @Override
    public void bind(IWindowInput window) {
        window.setListener(keyboard);
        window.setListener(mouse);
        this.window = window;
    }

    public void setMenu(IMenu menu) {
        mouse.setMenu(menu);
    }
    
}