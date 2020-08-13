package com.bubble.sample;

import com.bubble.font.Font;
import com.bubble.font.TextRenderer;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;

public class FontTes extends GraphicsTest {

    public static void main(String[] args) {
        new FontTes();
    }

    TextRenderer t;

    FontTes() {
        super();
        Shader.initiateShaders();
        t = new TextRenderer(Shader.getFontShader());
        setFont();
        window.setRenderer(new R());
        init();
    }

    void setFont() {
        final String path = "/Users/madscientist/Desktop/bitter-ht-regular-italic-bold-bold-italic/Bitter-Regular.otf";
        t.setFont(new Font(path, 2, 2, 0.4f));
    }

    class R implements IRenderer {

        public void render() {
            System.out.println("drawing text");
            t.drawText("t", 0, 0, 1.0f,0.0f,0.0f,0.0f,1.0f, true);
        }
    }
}