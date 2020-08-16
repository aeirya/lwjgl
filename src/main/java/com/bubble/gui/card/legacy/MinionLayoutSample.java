package com.bubble.gui.card.legacy;

import java.util.Map;

import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class MinionLayoutSample extends CardLayout {

    public MinionLayoutSample() {
        super(
            new Dimension(9.8f, 5.7f),
            new Point(0.1f, 1.7f),
            new CardFieldLayoutConfig(
                Map.of(
                    CardField.NAME, new Point(1, 9)
                ),
                Map.of(
                    CardField.NAME, CardLayoutSample.sampleFont
                )
            ),
            "minion"
        );
    }
    
}