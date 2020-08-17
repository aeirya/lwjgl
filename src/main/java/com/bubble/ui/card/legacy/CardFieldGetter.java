package com.bubble.ui.card.legacy;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class CardFieldGetter {
    private final Map<CardField, Supplier<Supplier<String>>> fieldGetter;
    private Card card;

    public CardFieldGetter() {
        fieldGetter = new EnumMap<>(CardField.class);
        fieldGetter.put(CardField.NAME, () -> card::getName);
        fieldGetter.put(CardField.MANA, () -> card::getManaCost);
        fieldGetter.put(CardField.DESCRIPTION, () -> card::getDescription);
        fieldGetter.put(CardField.DAMAGE, () -> card::getDamage);
        fieldGetter.put(CardField.HP, () -> card::getHealth);
        // also add: hero class, type, rarity
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getField(CardField field) {
        return fieldGetter.getOrDefault(field, () -> () -> "").get().get();
    }
}