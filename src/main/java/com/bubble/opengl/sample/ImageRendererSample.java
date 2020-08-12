package com.bubble.opengl.sample;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferShort;
import java.awt.image.DataBufferUShort;
import java.awt.image.DataBufferInt;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.bubble.opengl.*;
import com.bubble.util.TextureManager;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.system.MemoryUtil;

public class ImageRendererSample {
    private static final int SCR_WIDTH = 1000;
    private static final int SCR_HEIGHT = 800;

    private static final int BYTES_PER_PIXEL = 4;

    static final String VERTEX_SHADER_SOURCE = "#version 330 core\n"
    + "layout (location = 0) in vec3 aPos;\n"
    + "layout (location = 1) in vec3 aColor;\n"
    + "layout (location = 2) in vec2 aTexCoord;\n"
    + "out vec3 ourColor;\n"
    + "out vec2 TexCoord;\n"
    + "void main()\n"
    + "{\n"
    + "    gl_Position = vec4(aPos, 1.0);\n"
    + "    ourColor = aColor;\n"
    + "    TexCoord = vec2(aTexCoord.x, aTexCoord.y);\n"
    + "}\n\0";

    static final String FRAGMENT_SHADER_SOURCE = "#version 330 core\n"
    + "out vec4 FragColor;\n"
    + "in vec3 ourColor;\n"
    + "in vec2 TexCoord;\n"
    + "// texture sampler\n"
    + "uniform sampler2D texture1;\n"
    + "void main()\n"
    + "{\n"
    // + "    FragColor = texture(texture1, TexCoord);\n"
    + "     FragColor = vec4(ourColor, 1);"
    + "}\n\0";

    public static void main(String[] args) throws IOException {
        // window
        GLFW.glfwInit();
        macOsSupportTweak();
        long window = GLFW.glfwCreateWindow(SCR_WIDTH, SCR_HEIGHT, "Learn OpenGL", MemoryUtil.NULL, MemoryUtil.NULL);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSetFramebufferSizeCallback(window, ImageRendererSample::framebufferSizeCallback);
        
        GL.createCapabilities();
        
        Program shaderProgram = new Program(VERTEX_SHADER_SOURCE, FRAGMENT_SHADER_SOURCE);

        // data
        float[] vertices = {
            // positions          // colors           // texture coords
            1.0f,  1.0f, 0.0f,   1.0f, 1.0f, 0.0f,   1.0f, 1.0f, // top right
             1.0f, -1.0f, 0.0f,   1.0f, 0.0f, 0.0f,   1.0f, 0.0f, // bottom right
            -1.0f, -1.0f, 0.0f,   0.0f, 0.0f, 1.0f,   0.0f, 0.0f, // bottom left
            -1.0f,  1.0f, 0.0f,   0.0f, 1.0f, 0.0f,   0.0f, 1.0f  // top left 
        };

        int[] indices = {  // note that we start from 0!
           0, 1, 3,  // first Triangle
           1, 2, 3   // second Triangle
        };

        VertexBuffer vb = new VertexBuffer();

        VertexAttribute positions = new VertexAttribute(0, 3, 8);
        VertexAttribute color = new VertexAttribute(1, 3, 8);
        VertexAttribute texturePositions = new VertexAttribute(2, 2, 8);
    
        vb.upload(vertices, indices, positions, color, texturePositions);


        Texture texture = new TextureManager().getTexture("cat");
        texture.upload();
        
        vb.unbind();

        // render loop
        while (! GLFW.glfwWindowShouldClose(window)) {
            // input
            ImageRendererSample.processInput(window);

            // render
            glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            // glActiveTexture(GL_TEXTURE0);
            texture.bind();

            // draw our first triangle
            shaderProgram.bind();
            vb.bind();
            
            //glDrawArrays(GL_TRIANGLES, 0, 6)
            glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
    
            // glfw: swap buffers and poll IO events (keys pressed/released, mouse moved etc.)
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        // optional: de-allocate all resources once they've outlived their purpose:
        vb.destroy();
        shaderProgram.destroy();

        // glfw: terminate, clearing all previously allocated GLFW resources.
        // ------------------------------------------------------------------
        GLFW.glfwTerminate();
    }

    public static void framebufferSizeCallback(long window, long width, long height) {
        Logger.getGlobal().info(
            "changed window size!");
    }

    public static void processInput(long window) {
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS)
            GLFW.glfwSetWindowShouldClose(window, true);
    }

    public static void macOsSupportTweak() {
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 1);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
    }

    
}