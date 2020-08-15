package com.bubble.gui.card;

import com.bubble.input.mouse.IMouseListener;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class CardElementBuilder {
    private String id;
    private CardType type;
    private Point position;
    private Dimension size;
    private String description;
    private Color color;
    private String font;
    private String texture;
    private IMouseListener listener;

    public CardElementBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CardElementBuilder setType(CardType type) {
        this.type = type;
        return this;
    }

    public CardElementBuilder setPosition(Point position) {
        this.position = position;
        return this;
    }

    public CardElementBuilder setSize(Dimension size) {
        this.size = size;
        return this;
    }

    public CardElementBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public CardElementBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public CardElementBuilder setFont(String font) {
        this.font = font;
        return this;
    }

    public CardElementBuilder setTexture(String texture) {
        this.texture = texture;
        return this;

    }

    public CardElementBuilder setListener(IMouseListener listener) {
        this.listener = listener;
        return this;
    }

    public ICardElement toCardElement() {
        return new CardElement(id, type, position, size, description, font, color, texture);
    }
}