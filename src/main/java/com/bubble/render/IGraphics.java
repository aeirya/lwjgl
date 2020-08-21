package com.bubble.render;

import com.bubble.font2.Font;
import com.bubble.opengl.Texture;

public interface IGraphics {
    void setColor(float r, float g, float b, float a);
    void drawRect(float x, float y, float w, float h);
    void drawImage(float x, float y, float w, float h, Texture texture);
    
    void drawSimpleRect(float x, float y, float w, float h);
    void drawElement(float x, float y, float w, float h, Texture texture);

    void setFont(Font font);
    void drawText(String text, float x, float y, float scale);

    void clear();
}