package com.bubble.glfw;

import static org.lwjgl.glfw.GLFW.*;

import com.bubble.input.keyboard.IKeyEvent;
import com.bubble.input.keyboard.IKeyListener;
import com.bubble.input.keyboard.KeyEvent;
import com.bubble.input.keyboard.IKeyEvent.KeyEventType;

import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWKeyCallback;

class GlfwKeyboardInput {

    private GLFWKeyCallback keyCallback = new GLFWKeyCallback(){
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {    
            handleKeyEvent(key, action);
        }

        private void handleKeyEvent(int key, int action) {
            switch(action) {
                case GLFW_PRESS:
                keypress(key);
                break;
                case GLFW_RELEASE:
                keyrelease(key);
                break;
                case GLFW_REPEAT:
                keyhold(key);
                break;
                default:
                break;
            }
        }

        private void keypress(int key) {
            onKeyPress(new KeyEvent(key, KeyEventType.PRESS));
        }
    
        private void keyrelease(int key) {
            onKeyRelease(new KeyEvent(key, KeyEventType.RELEASE));
        }
    
        private void keyhold(int key) {
            onKeyHold(new KeyEvent(key, KeyEventType.HOLD));
        }
    };

    private GLFWCharCallback charCallback = new GLFWCharCallback(){
        public void invoke(long window, int codepoint) {
            onChar(codepoint);
        }
    };

    private IKeyListener listener;

    public GlfwKeyboardInput(GlfwWindow window) {
        bind(window);
    }

    public void bind(GlfwWindow window) {
        window.bind(this);
    }

    public void bind(long window) {
        keyCallback.set(window);
        charCallback.set(window);
    }

    public void unbind() {
        keyCallback.set(0);
        charCallback.set(0);
    }

    public void onKeyPress(IKeyEvent event) {
        listener.onKeyPress(event);
    }

    public void onKeyRelease(IKeyEvent event) {
        listener.onKeyRelease(event);
    }

    public void onKeyHold(IKeyEvent event) {
        listener.onKeyHold(event);
    }

    public void onChar(int codepoint) {
        listener.onCharCallback(codepoint);
    }

    public void setListener(IKeyListener listener) {
        this.listener = listener;
    }
}