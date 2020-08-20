package com.bubble.sample;

import com.bubble.font.VertexBuilder;
import com.bubble.font2.Font;
import com.bubble.font2.TextRenderer;
import com.bubble.glfw.GlfwWindow;
import com.bubble.opengl.Vec2;
import com.bubble.opengl.Vec4;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.render.Graphics;
import com.bubble.render.Shader;
import com.bubble.std.Dimension;
import com.bubble.std.Point;
import com.bubble.util.resource.EnumTexture;
import com.bubble.util.resource.TextureManager;
import org.lwjgl.opengl.GL11;

public class NewNewFont {
    public static void main(String[] args) {
        GlfwWindow window = new GlfwWindow();
        Shader.initiateShaders();
        TextRenderer renderer = new TextRenderer(
            Shader.getFontShader()
        );
        Font font = new Font("OpenSans-Regular.ttf", 1024, 1024, 64);
        renderer.setFont(font);

        TextureManager textures = new TextureManager();

        /*VertexBufferBuilder builder = new VertexBufferBuilder();
        builder.setAttribute(0, 2, 8);
        builder.setAttribute(1, 2, 8);
        builder.setAttribute(2, 4, 8);
        builder.begin();
        builder.addVertex(new Vec2(-0.5F, -0.5F));
        builder.addVertex(new Vec2(0.0F, 1.0F));
        builder.addVertex(new Vec4(1.0F, 1.0F, 1.0F, 1.0F));

        builder.addVertex(new Vec2(-0.5F,  0.5F));
        builder.addVertex(new Vec2(0.0F, 0.0F));
        builder.addVertex(new Vec4(1.0F, 1.0F, 1.0F, 1.0F));

        builder.addVertex(new Vec2( 0.5F, -0.5F));
        builder.addVertex(new Vec2(1.0F, 1.0F));
        builder.addVertex(new Vec4(1.0F, 1.0F, 1.0F, 1.0F));

        builder.addVertex(new Vec2( 0.5F,  0.5F));
        builder.addVertex(new Vec2(1.0F, 0.0F));
        builder.addVertex(new Vec4(1.0F, 1.0F, 1.0F, 1.0F));

        builder.addTriangle(0, 1, 2);
        builder.addTriangle(2, 1, 3);
        builder.end();

        VertexBuffer buffer = builder.getVAO();*/

        Graphics g = new Graphics() {
            @Override
            public void render() {
                 //this.drawSimpleRect(0, 0, 1, 1);
                 //this.draw();
                drawImage(new Point(0, 0), new Dimension(1, 1), textures.getTexture("cat"));
                this.draw();
                this.clear();
                renderer.drawText("Something long", -0.5F, 0, 0.002f, 1, 1, 1, 1, true);
                /*Shader.getFontShader().bind();
                buffer.bind();
                buffer.draw();*/
            }
        };


        window.setRenderer(g);
        window.start();

        //buffer.destroy();
    }
}