package com.bubble.render;

import com.bubble.opengl.Program;
import com.bubble.util.config.Config;
import com.bubble.util.file.FileLoader;

public class Shader extends Program {
    private static Shader textureShader;
    private static Shader coloredShader;
    private static Shader elementShader;
    private static Shader shapeShader;
    private static Shader fontShader;

    private Shader(String vertSource, String fragSource) { 
        super(vertSource, fragSource);
    }

    public static void initiateShaders() {
        coloredShader = gen("color-shader");
        textureShader = gen("image-shader");
        elementShader = gen("element-shader");
        shapeShader = gen("shape-shader");
        fontShader = gen("font-shader");
    }

    public static Shader gen(String name) {
        return new Shader(read(name + ".vert"), read(name + ".frag"));
    }

    private static String read(String name) {
        return new FileLoader(Config.getShaderPath() + name).load();
    }

    public static Shader getTextureShader() {
        return textureShader;
    }

    public static Shader getColoredShader() {
        return coloredShader;
    }

    public static Shader getElementShader() {
        return elementShader;
    }

    public static Shader getShapeShader() {
        return shapeShader;
    }

    public static Shader getFontShader() {
        return fontShader;
    }
}