package com.bubble.ui.element;

public class TextArea extends Textbox {

    public TextArea(IElement element) {
        super(element);
        this.isMultiline = true;
        setAlign(Align.TOP_LEFT);
    }
    
}