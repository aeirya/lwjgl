package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.gui.GuiRenderer;
import com.bubble.render.Shader;
import com.bubble.util.resource.TextureManager;

public class SimpleElementRendererT {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        Shader.initiateShaders();
        GuiRenderer g = new GuiRenderer(new TextureManager());
        // g.addElement(new Button());
        window.setRenderer(g);
        window.start();
    }
} 