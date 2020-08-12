package com.bubble.opengl.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.render.IRenderer;
import com.bubble.render.Renderer;
import com.bubble.util.TextureManager;

public class SimpleImageRendering {
    public static void main(String[] args) {
        TextureManager textManager = new TextureManager();
        GlfwWindow window = new GlfwWindow();
        IRenderer renderer = new Renderer(textManager);
        window.setRenderer(renderer);
        window.start();
    }
}