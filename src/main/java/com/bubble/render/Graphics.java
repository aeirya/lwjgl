package com.bubble.render;

import java.util.List;

import com.bubble.font2.Font;
import com.bubble.opengl.Texture;
import com.bubble.render.gmemory.GraphicsMemory;
import com.bubble.render.gmemory.IDrawable;
import com.bubble.std.Color;

public class Graphics implements IRenderer, IAdvancedGraphics {
    
    private final GraphicsBufferBuilder gbb;
    private final GraphicsMemory memory;
    private Color color;
    private Font font;

    public Graphics() {
        gbb = new GraphicsBufferBuilder();
        memory = new GraphicsMemory();
        resetColor();
    }

    public void clear() {
        memory.clear();
        resetColor();
    }
    
    private void resetColor() {
        color = Color.WHITE;
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
    
    public void drawFont(float x, float y, float w, float h, Texture texture, float startU, float endU, float startV, float endV) {
        memory.add(gbb.drawTextBuffer(x, y, w, h, startU, endU, startV, endV), Shader.getTextureShader(), texture);
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void resetFont() {
        // not implemented
    }
    
    public void drawElement(float x, float y, float w, float h, Texture texture) {
        if (texture == null) drawRect(x, y, w, h);
        else memory.add(gbb.drawElementBuffer(x, y, w, h, color), Shader.getElementShader(), texture);
    }

    public void drawText(String text, float x, float y, float scale) {
        // not implemented
    }

    private void draw(List<IDrawable> drawables) {
        drawables.forEach(IDrawable::draw);
    }
    
    protected void draw() {
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