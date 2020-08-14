package com.bubble.gui;

import com.bubble.glfw.GlfwWindow;
import com.bubble.input.MouseInput;
import com.bubble.render.Shader;

public class GameGraphics {
    private final IGuiRenderer gui;
    private final GlfwWindow window;
    private final MouseInput mouse;

    private Menu currentMenu;

    public GameGraphics() {
        window = new GlfwWindow();
        gui = new GuiRenderer();
        mouse = new MouseInput(window);
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