package com.bubble.opengl;

import static org.lwjgl.opengl.GL20.*;

public class Program {
    
    private final int id;

    public Program(String vert, String frag) {
        id = glCreateProgram();
        
        Shader vertShader = addShader(vert, GL_VERTEX_SHADER);
        Shader fragShader = addShader(frag, GL_FRAGMENT_SHADER);
        
        glLinkProgram(id);
        
        vertShader.delete();
        fragShader.delete();
    }

    private Shader addShader(String source, int type) {
        final Shader shader = new Shader(source, type);
        shader.attach(id);
        return shader;
    }

    public void bind() {
        glUseProgram(id);
    }

    public void unbind() {
        glUseProgram(0);
    }

    public void destroy() {
        glDeleteProgram(id);
    }

    public void setBool(String name, boolean value) {        
        setInt(name, value ? 1 : 0);
    }

    public void setInt(String name, int value) { 
        glUniform1i(glGetUniformLocation(id, name), value);
    }

    public void setFloat(String name, float value) { 
        glUniform1f(glGetUniformLocation(id, name), value); 
    }
}