package com.bubble.gui.element;

import com.bubble.gui.IGuiRenderer;

public class Textbox extends Element implements ITextbox {
    public Textbox(IElement element) {
        super(element);
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

    private static String removeLastCharacter(String str) {
        if (str.length() == 0) return "";
        else return str.substring(0, str.length() - 1);
    }

    @Override
    public void renderComponent(IGuiRenderer r) {
        super.renderComponent(r);
        r.drawText(this.getText(), this.getPosition(), this.getFont());
    }
}