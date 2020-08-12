package com.bubble.render;

import com.bubble.opengl.Program;
import com.bubble.opengl.Shader;
import com.bubble.opengl.Texture;
import com.bubble.opengl.Vec2D;
import com.bubble.opengl.Vertex;
import com.bubble.opengl.VertexBuffer;
import com.bubble.opengl.VertexBufferBuilder;
import com.bubble.util.TextureManager;
import com.bubble.util.file.FileLoader;

public class Renderer implements IRenderer {
    private final Texture texture;
    private final TextureManager texManager;
    private final Program shader;
    private static final String shaderPath = "./assets/shader/";
    private final VertexBuffer vb;

    public Renderer(TextureManager texManager) {
        this.texManager = texManager;
        texture = texManager.getTexture("cat");
        shader = loadShader();
        vb = createVB();
        texture.upload();
        vb.unbind();
    }
    
    public void render() {
        texture.bind();
        shader.bind();
        vb.bind();
        vb.draw();
        texture.unbind();
        shader.unbind();
    }

    private VertexBuffer createVB() {
        final VertexBufferBuilder vbb = new VertexBufferBuilder();
        
        vbb.begin();

        vbb.addVertex(new Vertex(1.0f, 1.0f, 0.0f));
        vbb.addVertex(new Vertex(1.0f, 1.0f, 0.0f));
        vbb.addVertex(new Vec2D(1.0f, 1.0f));
        
        vbb.addVertex(new Vertex(1.0f, -1.0f, 0.0f));
        vbb.addVertex(new Vertex(1.0f, 0.0f, 0.0f));
        vbb.addVertex(new Vec2D(1.0f, 0.0f));
        
        vbb.addVertex(new Vertex(-1.0f, -1.0f, 0.0f));
        vbb.addVertex(new Vertex(0.0f, 0.0f, 1.0f));
        vbb.addVertex(new Vec2D(0.0f, 0.0f));
        
        vbb.addVertex(new Vertex(-1.0f, 1.0f, 0.0f));
        vbb.addVertex(new Vertex(0.0f, 1.0f, 0.0f));
        vbb.addVertex(new Vec2D(0.0f, 1.0f));
        
        vbb.addTriangle(0, 1, 3);
        vbb.addTriangle(1, 2, 3);

        vbb.setAttribute(0, 3, 8);
        vbb.setAttribute(1, 3, 8);
        vbb.setAttribute(2, 2, 8);

        vbb.end();

        return vbb.getVAO();
    }

    private Program loadShader() {
        String filename = shaderPath + "shader";
        return new Program(
            load(filename + ".vert"),
            load(filename + ".frag")
            );
    }

    private String load(String file) {
        return new FileLoader(file).load();
    }
}