package com.bubble.gui;

import com.bubble.glfw.GlfwWindow;
import com.bubble.input.GameInput;
import com.bubble.render.Shader;
import com.bubble.util.config.Config;

public class GameGraphics {
    private final IGuiRenderer guiRenderer;
    private final GlfwWindow window;
    private final GameInput input;
    private final IGuiManager gui;

    public GameGraphics() {
        Config.load("assets");
        window = new GlfwWindow();
        guiRenderer = new GuiRenderer();
        input = new GameInput(window);
        gui = new GuiInputManager();
        gui.bind(input);
        launch(new Menu());
        init();
    }
    
    private void init() {
        Shader.initiateShaders();
        window.setRenderer(guiRenderer);
        window.start();
    }
    
    public void launch(Menu menu) {
        gui.launch(menu);
        menu.addTo(guiRenderer);
    }
}