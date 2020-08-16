package com.bubble.graphics;

import com.bubble.glfw.GlfwWindow;
import com.bubble.graphics.menu.MenuType;
import com.bubble.gui.IGuiManager; 
import com.bubble.gui.Menu;
import com.bubble.input.GameInput;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;
import com.bubble.util.config.Config;

public class GameGraphics {
    private final IRenderer renderer;
    private final GlfwWindow window;
    private final GameInput input;
    private final IGuiManager gui;

    public GameGraphics() {
        Config.load("assets");
        window = new GlfwWindow();
        input = new GameInput(window);
        gui = new GuiManager();
        gui.bind(input);
        renderer = new GameRenderer(gui);
        launch(MenuType.MAIN);
        init();
    }

    private void init() {
        Shader.initiateShaders();
        window.setRenderer(this::render);
        window.start();
    }

    public void launch(MenuType menu) {
        launch(new Menu());
        //change this
    }

    public void launch(Menu menu) {
        gui.launch(menu);
    }

    private void render() {
        renderer.render();
    }
}