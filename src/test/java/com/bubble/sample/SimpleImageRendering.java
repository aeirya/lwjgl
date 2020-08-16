package com.bubble.sample;

import com.bubble.glfw.GlfwWindow;
import com.bubble.opengl.Texture;
import com.bubble.render.Graphics;
import com.bubble.render.Shader;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.util.resource.TextureManager;

public class SimpleImageRendering {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        TextureManager textManager = new TextureManager();
        // IRenderer renderer = new Renderer(textManager);
        // window.setRenderer(renderer);
        Shader.initiateShaders();
        Graphics g = new Graphics();
        final Texture cat = textManager.getTexture("bear");
        // g.drawSimpleRect(-0.25f, 0.0f, 0.5f, 0.75f);
        g.drawImage(-0.5f, -0.5f, 0.24f, 0.3f, cat);
        g.drawImage(-1.0f, 1.0f, 1.0f, 1.0f,  cat);
        // g.drawElementImage(0.0f, 0.0f, 0.5f, 0.5f, cat);
        g.drawElement(new Point(0, 0), new Dimension(1, 1), cat, new Color(100, 255, 100).brighter());
        window.setRenderer(g);
        window.start();
    }

}