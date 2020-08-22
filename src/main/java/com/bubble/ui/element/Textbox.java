package com.bubble.ui.element;

import com.bubble.input.mouse.IMouseAdapter;

public class Textbox extends Element implements ITextbox {
    
    protected boolean isMultiline;

    public Textbox(IElement element) {
        super(element);
        setMouseListener(new TextboxMouseListener());
        setAlign(Align.LEFT);
        isMultiline = false;
    }

    public void write(String text) {
        setText(getText() + text);
    }

    public void delete() {
        setText(removeLastCharacter(getText()));
    }
    
    public void clear() {
        setText("");
    }

    public void nextLine() {
        if (isMultiline) setText(getText() + "\n");
    }

    private static String removeLastCharacter(String str) {
        if (str == null || str.length() == 0) return "";
        else return str.substring(0, str.length() - 1);
    }

    private class TextboxMouseListener implements IMouseAdapter {
        
    }
}