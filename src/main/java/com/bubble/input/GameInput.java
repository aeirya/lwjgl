package com.bubble.input;

import com.bubble.gui.IGuiManager;
import com.bubble.input.keyboard.IKeyListener;
import com.bubble.input.keyboard.KeyboardInput;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.input.mouse.IWindowInput;
import com.bubble.input.mouse.MouseInput;

public class GameInput implements IGameInput {

    private MouseInput mouse;
    private KeyboardInput keyboard;
    private IWindowInput window;

    public GameInput(IWindowInput window) {
        mouse = new MouseInput(window);
        keyboard = new KeyboardInput(window);
    }

    public void setListener(MouseInput listener) {
        this.mouse = listener;
        bind(window);
    }

    public void setListener(KeyboardInput listener) {
        this.keyboard = listener;
        bind(window);
    }

    public void bindListener(IKeyListener listener) {
        keyboard.setListener(listener);
    }

    public void bindListener(IMouseListener listener) {
        mouse.setListener(listener);
    }

    public void bindGuiManager(IGuiManager gui) {
        mouse.setGuiManager(gui);
    }

    @Override
    public void bind(IWindowInput window) {
        window.setListener(keyboard);
        window.setListener(mouse);
        this.window = window;
    }
}