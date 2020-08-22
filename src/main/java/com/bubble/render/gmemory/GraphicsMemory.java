package com.bubble.render.gmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bubble.opengl.Texture;
import com.bubble.opengl.VertexBuffer;
import com.bubble.render.Shader;

public class GraphicsMemory {
    
    private final Map<Shader, List<IDrawable>> drawMap;

    public GraphicsMemory() {
        drawMap = new HashMap<>();
    }

    public void clear() {
        drawMap.values().stream().forEach(
            drawlist -> {
                drawlist.forEach(IDrawable::destroy);
                drawlist.clear();
            }
        );
    }

    private void add(IDrawable drawable, Shader shader) {
        if (!drawMap.containsKey(shader)) drawMap.put(shader, new ArrayList<>());
        drawMap.get(shader).add(drawable);
    }
    
    public void add(VertexBuffer vb, Shader shader) {
        add(new Drawable(vb), shader);
    }
    
    public void add(VertexBuffer vb, Shader shader, Texture texture) {
        if (texture != null) {
            texture.upload();
            add(new TextureDrawable(vb, texture), shader);
            texture.unbind();
        } else {
            add(vb, shader);
        }
    }

    public Map<Shader, List<IDrawable>> fetch() {
        return drawMap;
    }
}
