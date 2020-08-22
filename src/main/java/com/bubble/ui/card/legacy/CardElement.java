package com.bubble.ui.card.legacy;

public class CardElement implements ICardElement {
    private final GuiElement element;
    private final Card card;

    public CardElement(GuiElement element, Card card) {
        this.element = element;
        this.card = card;
    }
    
    @Override
    public void paint(ICardElementRenderer renderer) {
        renderer.render(card, element);
    }

}