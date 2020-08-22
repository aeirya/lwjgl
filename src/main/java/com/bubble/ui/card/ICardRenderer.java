package com.bubble.ui.card;

import com.bubble.render.IRenderer;

public interface ICardRenderer extends IRenderer {
    void render(ICardElement card);
}