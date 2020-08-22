package com.bubble.ui.card.legacy;

public class FieldFont {
    private final String fontName;
    private final float scale;

    public FieldFont(String fontName, float scale) {
        this.fontName = fontName;
        this.scale = scale;
    }

    public String getFontName() {
        return fontName;
    }

    public float getScale() {
        return scale;
    }


}