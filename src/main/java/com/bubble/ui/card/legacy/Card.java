package com.bubble.ui.card.legacy;


public class Card {
    String name;
    String manaCost;
    
    String description;

    String health;
    String damage;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public String getDescription() {
        return description;
    }

    public String getHealth() {
        return health;
    }

    public String getDamage() {
        return damage;
    }    
}