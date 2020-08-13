package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.opengl.Texture;
import com.bubble.render.Graphics;
import com.bubble.render.IRenderer;
import com.bubble.render.Renderer;
import com.bubble.render.Shader;
import com.bubble.util.TextureManager;

public class SimpleImageRendering {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        TextureManager textManager = new TextureManager();
        // IRenderer renderer = new Renderer(textManager);
        // window.setRenderer(renderer);
        Shader.initiateShaders();
        Graphics g = new Graphics();
        final Texture cat = textManager.getTexture("cat");
        g.drawRect(0.0f, 0.0f, 0.5f, 0.25f);
        // g.drawImage(-0.5f, -0.5f, 0.24f, 0.3f, cat);
        g.drawImage(-1.0f, -1.0f, 1.0f, 1.0f,  cat);
        // g.drawElementImage(0.0f, 0.0f, 0.5f, 0.5f, cat);
        window.setRenderer(g);
        window.start();
    }
}