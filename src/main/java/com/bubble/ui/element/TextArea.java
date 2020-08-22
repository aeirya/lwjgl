package com.bubble.ui.element;

public class TextArea extends Textbox {

    private int maxLines = 0;
    private int lines = 0;

    public TextArea(IElement element) {
        super(element);
        this.isMultiline = true;
        setAlign(Align.TOP_LEFT);
        maxLines = 9;
    }
    
    @Override
    public void nextLine() {
        if (maxLines != 0 && lines < maxLines || maxLines == 0) {
            lines += 1;
            super.nextLine();
        }
    }

    @Override
    public void delete() {
        if(getText() != null) {
            if (getText().charAt(getText().length() - 1) == '\n') {
                lines -= 1;
            }
            super.delete();
        }
    }

    @Override
    public void clear() {
        super.clear();
        this.lines = 0;
    }
    
}