package com.bubble.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bubble.opengl.Texture;
import com.bubble.opengl.VertexBuffer;
import com.bubble.std.Color;

public class Graphics implements IRenderer, IAdvancedGraphics {
    
    private Color color;
    private final Map<Shader, List<IDrawable>> drawMap;
    private GraphicsBufferBuilder gbb;

    public Graphics() {
        drawMap = new HashMap<>();
        gbb = new GraphicsBufferBuilder();
        color = Color.GRAY;
    }

    private void add(IDrawable drawable, Shader shader) {
        if (!drawMap.containsKey(shader)) drawMap.put(shader, new ArrayList<>());
        drawMap.get(shader).add(drawable);
    }

    public void setColor(float r, float g, float b, float a) {
        color = new Color(r, g, b, a);
    }

    public void clear() {
        drawMap.clear();
    }

    public void add(VertexBuffer vb, Shader shader) {
        add(new Drawable(vb, shader), shader);
        vb.unbind();
    }

    private void add(VertexBuffer vb, Shader shader, Texture texture) {
        texture.upload();
        add(new TextureDrawable(vb, texture, shader), shader);
        vb.unbind();
    }

    public void drawSimpleRect(float x, float y, float w, float h) {
        add(gbb.drawSimpleRectBuffer(x, y, w, h), Shader.getShapeShader());
    }

    public void drawRect(float x, float y, float w, float h) {
        add(gbb.drawRectBuffer(x, y, w, h, color), Shader.getColoredShader());
    }

    public void drawImage(float x, float y, float w, float h, Texture texture) {
        add(gbb.drawImageBuffer(x, y, w, h), Shader.getTextureShader(), texture);
    }

    private void addElement(VertexBuffer vb, Texture texture) {
        add(vb, Shader.getElementShader(), texture);
    }
    
    public void drawElement(float x, float y, float w, float h, Texture texture) {
        addElement(gbb.drawElementBuffer(x, y, w, h, color), texture);
    }
    
    public void draw() {
        drawMap.forEach((k, v) -> draw(v));
    }
    
    private void draw(List<IDrawable> drawables) {
        drawables.forEach(IDrawable::draw);
    }
    
    public void render() {
        draw();
    }
}