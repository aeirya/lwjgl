package com.bubble;

import java.awt.Component;

import com.bubble.font2.Font;
import com.bubble.font2.TextRenderer;
import com.bubble.glfw.GlfwWindow;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;

public class FontRender {
    public static void main(String[] args) {
        new FontRender();
    }

    TextRenderer t;

    FontRender() {
        GlfwWindow window = new GlfwWindow();
        Shader.initiateShaders();
        t = new TextRenderer(Shader.getFontShader());
        Font font = new Font("assets/fonts/GrandHotel-Regular.otf", 1024, 1024, 64);
        t.setFont(font);
        IRenderer renderer = new R();
        window.setRenderer(renderer);
        window.start();
    }

    class R implements IRenderer {
        int i = 0;
        String text = "hi";

        public void render() {
            t.drawText(text, 0, 0, 0.002f, 1, 1, 1, 1, true);
            text = String.valueOf(i % 3);
            i += 1;
        }
    }
}