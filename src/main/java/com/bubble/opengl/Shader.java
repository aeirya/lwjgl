package com.bubble.opengl;

import static org.lwjgl.opengl.GL20.*;

import java.util.logging.Logger;

public class Shader {
    private final int id;

    public Shader(String source, int type) {
        id = glCreateShader(type);
        glShaderSource(id, source);
        glCompileShader(id);
        checkCompileStatus();
    }

    private void checkCompileStatus() {
        int[] status = new int[1];
        glGetShaderiv(id, GL_COMPILE_STATUS, status);
        if (status[0] == GL_FALSE) {
            final String msg = glGetShaderInfoLog(id);
            Logger.getGlobal().info(msg);
        }
    }

    public void attach(int program) {
        glAttachShader(program, id);
    }

    public void delete() {
        glDeleteShader(id);
    }
}