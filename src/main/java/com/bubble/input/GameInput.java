package com.bubble.input;

import com.bubble.input.keyboard.IKeyListener;
import com.bubble.input.keyboard.KeyboardInput;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.input.mouse.IWindowInput;
import com.bubble.input.mouse.MouseInput;
import com.bubble.ui.management.IGuiManager;

public class GameInput implements IGameInput {

    private MouseInput mouse;
    private KeyboardInput keyboard;
    private IWindowInput window;

    public GameInput(IWindowInput window) {
        mouse = new MouseInput(window);
        keyboard = new KeyboardInput(window);
    }

    public void bindListener(IKeyListener listener) {
        keyboard.setListener(listener);
    }

    public void bindListener(IMouseListener listener) {
        mouse.setListener(listener);
    }

    public void provideGuiManager(IGuiManager gui) {
        mouse.setGuiManager(gui);
    }

    public void changeListener(MouseInput listener) {
        this.mouse = listener;
        bind(window);
    }

    public void changeListener(KeyboardInput listener) {
        this.keyboard = listener;
        bind(window);
    }

    @Override
    public void bind(IWindowInput window) {
        window.setListener(keyboard);
        window.setListener(mouse);
        this.window = window;
    }
}