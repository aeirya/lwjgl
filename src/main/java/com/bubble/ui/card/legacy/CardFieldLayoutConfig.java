package com.bubble.ui.card.legacy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.bubble.std.Point;

public class CardFieldLayoutConfig {
    
    //point values are betweeon 0 and 10
    private final Map<CardField, Point> coordinates;
    private final Map<CardField, FieldFont> styles;
    private final CardFieldGetter getter;

    public CardFieldLayoutConfig(Map<CardField, Point> coordinates, Map<CardField, FieldFont> styles) {
        this.coordinates = coordinates;
        this.styles = styles;
        getter = new CardFieldGetter();
    }

    private Set<CardField> getFields() {
        return coordinates.keySet();
    }

    public List<FieldDrawable> apply(Card card) {
        getter.setCard(card);
        return getFields()
            .stream()
            .map(f -> new FieldDrawable(getter.getField(f), coordinates.get(f), styles.get(f).getFontName(), styles.get(f).getScale()))
            .collect(Collectors.toList());
    }
}