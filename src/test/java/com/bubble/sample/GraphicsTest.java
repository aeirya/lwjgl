package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.gui.GuiRenderer;
import com.bubble.render.Shader;

public abstract class GraphicsTest {

    GuiRenderer g;
    GlfwWindow window;

    GraphicsTest() {
        window = new GlfwWindow();
        Shader.initiateShaders();
        g = new GuiRenderer();
    }

    void init() {
        window.setRenderer(g);
        window.start();
    }
}