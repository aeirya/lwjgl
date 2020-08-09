package com.bubble.opengl;

public class DummyProgram extends Program {

    static final String VERTEX_SHADER_SHOURCE = "#version 330 core\n"
    + "layout (location = 0) in vec3 aPos;\n"
    + "void main()\n"
    + "{\n"
    + "   gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n"
    + "}\0";
    
    static final String FRAGMENT_SHADER_SOURCE = "#version 330 core\n"
    + "out vec4 FragColor;\n"
    + "void main()\n"
    + "{\n"
    + "   FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n"
    + "}\n\0";

    public DummyProgram() {
        super(VERTEX_SHADER_SHOURCE, FRAGMENT_SHADER_SOURCE);
    }
    
}