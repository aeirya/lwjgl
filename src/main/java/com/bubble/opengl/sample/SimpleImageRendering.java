package com.bubble.opengl.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.render.IRenderer;
import com.bubble.render.Renderer;
import com.bubble.util.TextureManager;

public class SimpleImageRendering {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        TextureManager textManager = new TextureManager();
        IRenderer renderer = new Renderer(textManager);
        window.setRenderer(renderer);
        window.start();
    }
}