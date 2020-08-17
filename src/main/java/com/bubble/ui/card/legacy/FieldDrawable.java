package com.bubble.ui.card.legacy;

import com.bubble.render.Graphics;
import com.bubble.std.Point;

public class FieldDrawable {
    private final String text;
    private final Point location;
    private final String font;
    private final float scale;

    public FieldDrawable(String text, Point location, String font, float scale) {
        this.text = text;
        this.font = font;
        this.location = location;
        this.scale = scale;
    }

    public void render(Graphics g, GuiElement reference) {
        g.setFont(font);
        g.drawText(
            text, 
            location.x / 10 * reference.getWidth() + reference.getX(), 
            -(1) * location.y / 10 * reference.getHeight() + reference.getY(), 
            scale
        );
    }
}