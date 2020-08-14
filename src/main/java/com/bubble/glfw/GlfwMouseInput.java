package com.bubble.glfw;

import com.bubble.input.IMouseListener;
import com.bubble.input.MouseState;
import com.bubble.std.Math;
import com.bubble.std.Point;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import static org.lwjgl.glfw.GLFW.*;

public class GlfwMouseInput {

    private IMouseListener listener;
    private GlfwMouseState state;
    private GlfwWindow window;

    public GlfwMouseInput(GlfwWindow window) {
        state = new GlfwMouseState();
        bind(window);
    }

    private final GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {
        @Override
        public void invoke(long w, double x, double y) {
            invoke(Math.glfwCoordToOpenGl(x, y, window.getWidth(), window.getHeight()));
        }

        private void invoke(Point mousePos) {
            state.setPosition(mousePos);
            state.setMoved(true);
            onMouseMove(getState());
        }

        private void onMouseMove(MouseState mouse) {
            if(listener != null) listener.onMouseMove(mouse);
            state.setMoved(false);
        }
    };

    private final GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback(){
        @Override
        public void invoke(long w, int button, int action, int mods) {
            if (button == GLFW_MOUSE_BUTTON_LEFT) {
                state.setClicked(action == GLFW_PRESS);
            } else if (button == GLFW_MOUSE_BUTTON_RIGHT) {
                state.setRightClicked(action == GLFW_PRESS);
            }
            if(action == GLFW_PRESS) onMouseClick(getState());
            else onMouseRelease(getState());
        }
    
        private void onMouseClick(MouseState mouse) {
            if(listener != null) listener.onMouseClick(mouse);
        }
    
        private void onMouseRelease(MouseState mouse) {
            if(listener != null) return;
        }
    };

    public void bind(GlfwWindow window) {
        window.bind(this);
        this.window = window;
    }

    public void bind(long window) {
        cursorPosCallback.set(window);
        mouseButtonCallback.set(window);
    }

    public void unbind() {
        cursorPosCallback.set(0);
        mouseButtonCallback.set(0);
    }

    private MouseState getState() {
        return new MouseState(state.getPosition(), state.isMoved(), state.isClicked(), state.isRightClicked());
    }

    public void setListener(IMouseListener listener) {
        this.listener = listener;
    }
}