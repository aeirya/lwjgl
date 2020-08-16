package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.gui.GuiRenderer;
import com.bubble.render.Shader;
import com.bubble.util.resource.TextureManager;

public abstract class GraphicsTest {

    GuiRenderer g;
    GlfwWindow window;

    GraphicsTest() {
        window = new GlfwWindow();
        Shader.initiateShaders();
        g = new GuiRenderer(new TextureManager());
        window.setRenderer(g);
    }

    void init() {
        window.start();
    }
}