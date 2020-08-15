package com.bubble.gui;


public class Textbox extends Element {
    public Textbox(IElement element) {
        super(element);
    }

    public void addText(String text) {
        setText(getText() + text);
    }

    public void backspace() {
        setText(removeLastCharacter(getText()));
    }

    private static String removeLastCharacter(String str) {
        if (str.length() == 0) return "";
        else return str.substring(0, str.length() - 1);
    }
}