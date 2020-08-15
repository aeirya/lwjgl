package com.bubble.gui;

import com.bubble.glfw.GlfwWindow;
import com.bubble.input.GameInput;
import com.bubble.render.Shader;
import com.bubble.util.config.Config;

public class GameGraphics {
    private final IGuiRenderer gui;
    private final GlfwWindow window;
    private final GameInput input;

    private Menu currentMenu;

    public GameGraphics() {
        Config.load("assets");
        window = new GlfwWindow();
        gui = new GuiRenderer();
        input = new GameInput(window);
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
        input.setMenu(menu);
        menu.addTo(gui);
    }
}