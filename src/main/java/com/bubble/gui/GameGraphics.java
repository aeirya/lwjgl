package com.bubble.gui;

import com.bubble.glfw.GlfwWindow;
import com.bubble.render.Shader;

public class GameGraphics {
    private final IGuiRenderer gui;
    private final GlfwWindow window;
    private Menu currentMenu;

    public GameGraphics() {
        window = new GlfwWindow();
        gui = new GuiRenderer();
        currentMenu = new Menu();
        launch(currentMenu);
        init();
    }
    
    private void init() {
        Shader.initiateShaders();
        window.setRenderer(gui);
        window.start();
    }
    
    public void launch(Menu menu) {
        this.currentMenu = menu;
        menu.listen(window);
        menu.addTo(gui);
    }
}