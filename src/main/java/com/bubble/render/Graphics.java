package com.bubble.render;

import java.util.List;

import com.bubble.opengl.Texture;
import com.bubble.std.Color;

public class Graphics implements IRenderer, IAdvancedGraphics {
    
    private final GraphicsBufferBuilder gbb;
    private final GraphicsMemory memory;
    private Color color;

    public Graphics() {
        gbb = new GraphicsBufferBuilder();
        memory = new GraphicsMemory();
        color = Color.GRAY;
    }

    public void clear() {
        memory.clear();
    }

    public void setColor(float r, float g, float b, float a) {
        color = new Color(r, g, b, a);
    }
    
    public void drawSimpleRect(float x, float y, float w, float h) {
        memory.add(gbb.drawSimpleRectBuffer(x, y, w, h), Shader.getShapeShader());
    }
    
    public void drawRect(float x, float y, float w, float h) {
        memory.add(gbb.drawRectBuffer(x, y, w, h, color), Shader.getColoredShader());
    }
    
    public void drawImage(float x, float y, float w, float h, Texture texture) {
        memory.add(gbb.drawImageBuffer(x, y, w, h), Shader.getTextureShader(), texture);
    }
    
    public void drawElement(float x, float y, float w, float h, Texture texture) {
        memory.add(gbb.drawElementBuffer(x, y, w, h, color), Shader.getElementShader(), texture);
    }

    private void draw(List<IDrawable> drawables) {
        drawables.forEach(IDrawable::draw);
    }
    
    private void draw() {
        memory.fetch().forEach(
            (shader, items) -> {
            shader.bind();
            draw(items);
        });
    }
    
    public void render() {
        draw();
    }
}