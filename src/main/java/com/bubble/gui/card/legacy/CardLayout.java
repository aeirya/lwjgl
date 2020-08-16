package com.bubble.gui.card.legacy;

import java.util.function.BiFunction;

import com.bubble.opengl.Texture;
import com.bubble.render.Graphics;
import com.bubble.std.Dimension;
import com.bubble.std.Math;
import com.bubble.std.Point;

public class CardLayout {
    private final Dimension imageSize;
    private final Point imageLocation;
    private final CardFieldLayoutConfig config; 
    private final String backgroundTexture;

    public CardLayout(Dimension imageSize, Point imageLocation, CardFieldLayoutConfig config, String background) {
        this.imageSize = imageSize;
        this.imageLocation = imageLocation;
        this.config = config;
        this.backgroundTexture = background;
    }

    public BiFunction<Texture, Texture, IDrawable> apply(Card card, GuiElement element) {
        return (texture, background) -> g -> render(g, card, texture, background, element);
    }

    public void render(Graphics g, Card card, Texture image, Texture background, GuiElement element) {
        renderImage(g, image, background, element);
        renderTexts(g, card, element);
    }

    private void renderImage(Graphics g, Texture image, Texture background, GuiElement element) {
        g.drawImage(element.getLocation(), element.getSize(), background);
        g.drawImage(
            imageLocation.scale(0.1f).mul(Math.toPoint(imageSize)).sum(element.getLocation()),
            imageSize.scaled(0.1f).scaled(element.getWidth(), element.getHeight()),
            image
        );
    }

    private void renderTexts(Graphics g, Card card, GuiElement element) {
        config.apply(card).forEach(f -> f.render(g, element));
    }

    public String getBackground() {
        return backgroundTexture;
    }

}