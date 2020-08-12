package com.bubble.render;

import com.bubble.opengl.Texture;

public interface IGraphics {
    void setColor(float r, float g, float b, float a);
    void fillRect(float x, float y, float w, float h);
    void drawImage(float x, float y, float w, float h, Texture texture);
}