package com.bubble.glfw;

import static org.lwjgl.glfw.GLFW.*;

import java.util.logging.Logger;

import com.bubble.render.IRenderer;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class GlfwWindow {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private long window;
    private int refreshWait = 20;
    private String title = "Window";
    private IRenderer renderer;

    public GlfwWindow() {
        init();
    }

    public void init() {
        glfwInit();
        macOsSupportTweak();
        window = glfwCreateWindow(WIDTH, HEIGHT, title, MemoryUtil.NULL, MemoryUtil.NULL);
        glfwMakeContextCurrent(window);
        glfwSetFramebufferSizeCallback(window, this::framebufferSizeCallback);
        GL.createCapabilities();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void start() {
        update();
    }

    public void update() {
        while (!glfwWindowShouldClose(window)) {
            processInput();
            render();
            refresh();
            sleep();
        }
        glfwTerminate();
    }

    private void macOsSupportTweak() {
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
    }

    private void framebufferSizeCallback(long window, int width, int height) {
        GL11.glViewport(0, 0, width, height);
        Logger.getGlobal().info(() -> "changed size to " + width + "," + height);
    }

    private void processInput() {
        if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
            glfwSetWindowShouldClose(window, true);
    }

    private void clear() {
        GL11.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    private synchronized void render() {
        if (renderer != null)
            renderer.render();
    }

    private void refresh() {
        glfwSwapBuffers(window);
        clear();
        glfwPollEvents();
    }

    public void setRenderer(IRenderer renderer) {
        this.renderer = renderer;
    }

    private void sleep() {
        try {
            Thread.sleep(refreshWait);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GlfwWindow();
    }
}