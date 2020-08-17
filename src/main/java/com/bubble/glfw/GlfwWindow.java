package com.bubble.glfw;

import static org.lwjgl.glfw.GLFW.*;

import java.util.logging.Logger;

import com.bubble.input.mouse.IMouseInputListener;
import com.bubble.input.mouse.IWindowInput;
import com.bubble.input.keyboard.IKeyListener;
import com.bubble.render.IRenderer;
import com.bubble.util.config.Constants;
import com.bubble.util.config.GameConfig;
import com.bubble.util.config.GameConfig.Screen;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class GlfwWindow implements IWindowInput {
    private final Screen screen;
    private final int width;
    private final int height;
    private long window;
    private int refreshWait;
    private String title = Constants.SCREEN_TITLE;

    private GlfwMouseInput input;
    private GlfwKeyboardInput keyboard;
    private IRenderer renderer;

    public GlfwWindow() {
        screen = GameConfig.getScreen();
        width = screen.getSize().getWidth();
        height = screen.getSize().getHeight();
        refreshWait = screen.getRefreshWait();
        init();
        setAspectRatio(screen.getRatio().W, screen.getRatio().H);
        input = new GlfwMouseInput(this);
        keyboard = new GlfwKeyboardInput(this);
    }

    public void init() {
        glfwInit();
        macOsSupportTweak();
        window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        glfwMakeContextCurrent(window);
        glfwSetFramebufferSizeCallback(window, this::framebufferSizeCallback);
        GL.createCapabilities();
        enableAlpha();
    }

    // tweaks
    private void enableAlpha() {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    private void macOsSupportTweak() {
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
    }

    private void setAspectRatio(int n, int d) {
        if (n == 0) n = -1;
        if (d == 0) d = -1;
        glfwSetWindowAspectRatio(window, n, d);
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

    // events
    private void framebufferSizeCallback(long window, int width, int height) {
        GL11.glViewport(0, 0, width, height);
        Logger.getGlobal().info(() -> "changed size to " + width + "," + height);
    }

    private void processInput() {
        if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
            glfwSetWindowShouldClose(window, true);
    }

    // render
    public void setRenderer(IRenderer renderer) {
        this.renderer = renderer;
    }

    private void render() {
        if (renderer != null)
            renderer.render();
    }

    private void refresh() {
        glfwSwapBuffers(window);
        clear();
        glfwPollEvents();
    }

    private void clear() {
        GL11.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    // 
    private void sleep() {
        try {
            Thread.sleep(refreshWait);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    // interaction with input
    public void bind(GlfwKeyboardInput input) {
        input.bind(window);
    }
    
    public void bind(GlfwMouseInput input) {
        input.bind(window);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // IWindow input 

    public void setListener(IMouseInputListener listener) {
        input.setListener(listener);
    }

    public void setListener(IKeyListener listener) {
        keyboard.setListener(listener);
    }
}