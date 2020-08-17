package com.bubble.sample;

import java.util.List;

import com.bubble.font.CharGlyph;
import com.bubble.font.Font;
import com.bubble.font.TextRenderer;
import com.bubble.font.VertexBuilder;
import com.bubble.font.VertexFormat;
import com.bubble.font.VertexFormatElement;
import com.bubble.opengl.Texture;
import com.bubble.opengl.Vec2;
import com.bubble.opengl.Vec3;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.util.resource.TextureManager;
import com.bubble.render.Graphics;

import static org.lwjgl.glfw.GLFW.*;

public class FontTes extends GraphicsTest {

    private VertexBuffer vb;

    public static void main(String[] args) {
        new FontTes();
    }

    TextRenderer t;

    FontTes() {
        super();
        Shader.initiateShaders();
        t = new TextRenderer(Shader.getTextureShader());
        setFont();
        window.setRenderer(new R());
        // this.drawRect();
        // Graphics g = new Graphics();
        // g.drawImage(new Point(0, 0), new Dimension(0.5f, 0.5f), texture);
        init();
    }

    void setFont() {
        final String path = "D:\\arial.ttf";    // TODO: Change this.
        Font f = new Font(path, 2000, 2000, 1000f);
        t.setFont(f);
        // f.getCharGlyph('c');
        for (int i = 0; i < 10; i++) {
            char c = (char) ((int) 'a' + i);
            f.getCharGlyph(c);
        }
    }

    void drawRect(){
        // VertexBuilder vbb = new VertexBuilder(new VertexFormat(List.of(VertexFormatElement.POSITION_2D, VertexFormatElement.UV)));
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        vbb.begin();
        // vbb.vertex(-1, -1, 0, 0);
        // vbb.vertex(-1, 1, 0, 1);
        // vbb.vertex(1, -1, 1, 0);
        // vbb.vertex(1, 1, 1, 1);
        vbb.addVertex(new Vec3(-1, -1, 0));
        vbb.addVertex(new Vec2(0, 0));
        vbb.addVertex(new Vec3(-1, 1, 0));
        vbb.addVertex(new Vec2(0, 1));
        vbb.addVertex(new Vec3(1, -1, 0));
        vbb.addVertex(new Vec2(1, 0));
        vbb.addVertex(new Vec3(1, 1, 0));
        vbb.addVertex(new Vec2(1, 1));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(1, 0, 3);
        vbb.setAttribute(0, 3, 5);
        vbb.setAttribute(1, 2, 5);
        vbb.end();
        // this.vb = vbb.flush();
        vb = vbb.getVAO();
    }

    class R implements IRenderer {

        public void render() {
            System.out.println("drawing text");
            // FontTes.this.t.getFont().getTexture().bind();
            // FontTes.this.vb.draw();
            Graphics g = new Graphics();
            Texture t = FontTes.this.t.getFont().getTexture();
            // CharGlyph a = FontTes.this.t.getFont().getCharGlyph('a');
            // g.drawFont(-1, 1, 2f, 2f, t, a.textureStartU, a.textureEndU, a.textureStartV, a.textureEndV);
            g.drawFont(-1, 1, 2f, 2f, t, 0, 1, 0, 1);
            // g.drawImage(new Point(-1, 1), new Dimension(2, 2), t);
            // g.drawElement(new Point(0, 0), new Dimension(0.5f, 0.5f), t, new Color(100, 20, 100, 1));
            g.render();
        }
    }
}