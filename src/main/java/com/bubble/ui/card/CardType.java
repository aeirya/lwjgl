package com.bubble.ui.card;

public enum CardType {
    MINION, SPELL, WEAPON;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}