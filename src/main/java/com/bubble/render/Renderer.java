package com.bubble.render;

import com.bubble.util.resource.TextureManager;

public abstract class Renderer implements IRenderer {
    protected final Graphics g;
    protected final TextureManager textures;

    public Renderer(TextureManager textures) {
        this.textures = textures;
        g = new Graphics();
    }
    
    @Override
    public void render() {
        g.render();
        clearMemory();
    }
    
    protected void clearMemory() {
        g.clear();
    }

    public Graphics getGraphics() {
        return g;
    }
}