package com.bubble.gui.card.legacy;

import com.bubble.opengl.Texture;
import com.bubble.render.Graphics;

public class CardView {

    private final IDrawable drawable;

    public CardView(Card card, GuiElement element, CardLayout layout, Texture texture, Texture background) {
        drawable = layout.apply(card, element).apply(texture, background);
    }

    public void render(Graphics g) {
        drawable.draw(g);
    }
}