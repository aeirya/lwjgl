package com.bubble.ui.card.legacy;

import java.util.List;

public interface ICardRenderer {
    void render(ICardElement card);
    
    default void render(List<ICardElement> cards) {
        cards.forEach(this::render);
    }
}