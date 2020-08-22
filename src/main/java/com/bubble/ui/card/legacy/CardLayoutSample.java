package com.bubble.ui.card.legacy;

import java.util.Map;

import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class CardLayoutSample extends CardLayout {

    public CardLayoutSample() {
        super(
            new Dimension(8.2f, 3.75f),
            new Point(0.55f, 1.75f),
            new CardFieldLayoutConfig(
                Map.of(
                    CardField.NAME, new Point(1, 5),
                    CardField.HP, new Point(0.5f, 4)
                ),
                Map.of(
                    CardField.NAME, sampleFont,
                    CardField.HP, sampleFont
                )
            ),
            "card"
            );
        
    }

    public static final FieldFont sampleFont = new FieldFont("font", 20);
    
}