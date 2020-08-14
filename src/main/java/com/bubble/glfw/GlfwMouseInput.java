package com.bubble.glfw;

import com.bubble.input.IMouseListener;
import com.bubble.input.MouseState;
import com.bubble.std.Point;

import org.lwjgl.glfw.GLFWCursorPosCallback;

public class GlfwMouseInput {

    private IMouseListener listener;

    public GlfwMouseInput(GlfwWindow window) {
        bind(window);
    }

    private final GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {
        @Override
        public void invoke(long window, double x, double y) {
            invoke((float) x, (float) y);
        }

        private void invoke(float x, float y) {
            onMouseMove(new MouseState(new Point(x, y), true));
        }
    };

    public void bind(GlfwWindow window) {
        window.bind(this);
    }

    public void bind(long window) {
        cursorPosCallback.set(window);
    }

    public void unbind() {
        cursorPosCallback.set(0);
    }

    public void onMouseMove(MouseState mouse) {
        if(listener != null) listener.onMouseMove(mouse);
    }

    public void onMouseClick(MouseState mouse) {
        if(listener != null) listener.onMouseClick(mouse);
    }

    public void setListener(IMouseListener listener) {
        this.listener = listener;
    }
}