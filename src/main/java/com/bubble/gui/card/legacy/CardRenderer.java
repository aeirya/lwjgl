package com.bubble.gui.card.legacy;

import com.bubble.gui.Renderer;
import com.bubble.opengl.Texture;
import com.bubble.util.resource.EnumTexture;
import com.bubble.util.resource.TextureManager;

public class CardRenderer extends Renderer implements ICardRenderer {
    private CardLayout layout;

    public CardRenderer(TextureManager textures) {
        super(textures);
        // layout = new CardLayoutSample();
        layout = new MinionLayoutSample();
    }

    public void render(ICardElement card) {
        card.paint(this::render);
    }

    public void render(Card card, GuiElement element) {
        new CardView(card, element, layout, getTexture(card), getTexture(layout)).render(g);
    }

    private Texture getTexture(Card card) {
        final Texture t =textures.getTexture(card.getName());
        return t != null ? t : textures.getTexture(EnumTexture.CARD);
    }

    private Texture getTexture(CardLayout layout) {
        return textures.getTexture(layout.getBackground());
    }
}