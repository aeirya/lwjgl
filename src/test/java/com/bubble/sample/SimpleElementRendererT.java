package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.gui.Button;
import com.bubble.gui.GuiRenderer;
import com.bubble.render.Shader;

public class SimpleElementRendererT {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        Shader.initiateShaders();
        GuiRenderer g = new GuiRenderer();
        g.addElement(new Button());
        window.setRenderer(g);
        window.start();
    }
}