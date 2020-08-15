package com.bubble.gui;

import com.bubble.glfw.GlfwWindow;
import com.bubble.input.MouseInput;
import com.bubble.input.keyboard.KeyListener;
import com.bubble.render.Shader;
import com.bubble.util.config.Config;

public class GameGraphics {
    private final IGuiRenderer gui;
    private final GlfwWindow window;
    private final MouseInput mouse;
    private final KeyListener keys;

    private Menu currentMenu;

    public GameGraphics() {
        Config.load("assets");
        window = new GlfwWindow();
        gui = new GuiRenderer();
        mouse = new MouseInput(window);
        keys = new KeyListener();
        window.setListener(keys);
        launch(new Menu());
        init();
    }
    
    private void init() {
        Shader.initiateShaders();
        window.setRenderer(gui);
        window.start();
    }
    
    public void launch(Menu menu) {
        this.currentMenu = menu;
        mouse.setMenu(menu);
        menu.addTo(gui);
    }
}