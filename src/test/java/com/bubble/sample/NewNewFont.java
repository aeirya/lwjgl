package com.bubble.sample;

import com.bubble.font2.Font;
import com.bubble.font2.TextRenderer;
import com.bubble.glfw.GlfwWindow;
import com.bubble.render.Graphics;
import com.bubble.render.Shader;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.util.resource.EnumTexture;
import com.bubble.util.resource.TextureManager;

public class NewNewFont {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        Shader.initiateShaders();
        TextRenderer renderer = new TextRenderer(
            Shader.getFontShader()
        );
        // renderer.setFont(font);
        Font font = new Font("OpenSans-Regular.ttf", 1024, 1024, 64);

        TextureManager textures = new TextureManager();

        Graphics g = new Graphics() {
            @Override
            public void render() {
                // this.drawSimpleRect(0, 0, 1, 1);
                // this.draw();
                // renderer.drawText("text", 0, 0, 0.01f, 1, 1, 1, 1, true);
                this.drawImage(new Point(0, 0), new Dimension(1, 1), font.getTexture());
                this.draw();
            }
        };
        
        window.setRenderer(g);
        window.start();
    }
}