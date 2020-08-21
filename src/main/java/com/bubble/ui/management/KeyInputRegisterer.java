package com.bubble.ui.management;

import com.bubble.input.keyboard.IKeyAdapter;
import com.bubble.input.keyboard.IKeyEvent;
import com.bubble.ui.element.ElementType;
import com.bubble.ui.element.IElement;
import com.bubble.ui.element.ITextbox;

import org.lwjgl.glfw.GLFW;

class KeyInputRegisterer implements IKeyAdapter {
    
    private final GuiInputManager gui;

    KeyInputRegisterer(GuiInputManager gui) {
        this.gui = gui;
    }

    @Override
    public void onCharCallback(int codepoint) {
        charCallback(codepoint, getActiveTextbox());
    }

    void charCallback(int codepoint, ITextbox current) {
        if (current != null) writeText(codepoint, current);
    }

    private ITextbox getActiveTextbox() {
        final IElement active = gui.getActiveElement();
        if (active == null) return null;
        if (active.getType() == ElementType.TEXTBOX) return (ITextbox) active;
        else return null;
    }

    private void writeText(int codepoint, ITextbox textbox) {
        textbox.write(Character.toString(codepoint));
    }

    @Override
    public void onKeyPress(IKeyEvent event) {
        keyPress(event, getActiveTextbox());
    }

    private void keyPress(IKeyEvent event, ITextbox textbox) {
        if (textbox != null) {
            if (event.getKey() == GLFW.GLFW_KEY_BACKSPACE) {
                textbox.delete();
            } else if(event.getKey() == GLFW.GLFW_KEY_ESCAPE) {
                textbox.clear();
            }
        }
    }

    @Override
    public void onKeyHold(IKeyEvent event) {
        keyHold(event, getActiveTextbox());
    }

    private void keyHold(IKeyEvent event, ITextbox textbox) {
        if (textbox != null) {
            if (event.getKey() == GLFW.GLFW_KEY_BACKSPACE) {
                textbox.clear();
            }
        }
    }
}
