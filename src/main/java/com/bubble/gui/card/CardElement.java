package com.bubble.gui.card;

import java.util.logging.Logger;

import com.bubble.gui.IGuiRenderer;
import com.bubble.input.mouse.IMouseAdapter;
import com.bubble.input.mouse.IMouseListener;
import com.bubble.input.mouse.MouseState;
import com.bubble.std.Color;
import com.bubble.std.Dimension;
import com.bubble.std.Point;

public class CardElement implements ICardElement{
    private String name;
    private CardType type;
    private Point position;
    private Dimension size;
    private String description;
    private Color color;
    private String font;
    private String texture;
    private IMouseListener listener;

    private int manaCost;
    private int health;
    private int attack;
    
    public CardElement() {}

    public CardElement(String name, CardType type, Point position, Dimension size, String descrption, String font, Color color,
    String texture) {
        this.name = name;
        this.type = type;
        this.position = position;
        this.size = size;
        this.description = descrption;
        this.color = color;
        this.font = font;
        this.texture = texture;
    }

    public CardElement(ICardElement ce) {
        this.name = ce.getName();
        this.type = ce.getType();
        this.position = ce.getPosition();
        this.size = ce.getSize();
        this.description = ce.getDescription();
        this.color = ce.getColor();
        this.font = ce.getFont();
        this.texture = ce.getTexture();
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setText(String text) {
        this.description = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public IMouseListener getMouseListener() {
        return listener;
    }

    public void setMouseListener(IMouseListener listener) {
        this.listener = listener;
    }

    public void paintComponent(IGuiRenderer r) {
        if (type != null) {
            // TODO: Set types.
            switch(type) {  
                case MINION:
                break;
                case WEAPON:
                break;
                case SPELL:
                break;
                default:
                Logger.getGlobal().warning("not rendering");
                break;
            }
        }
    }

    private static CardElement genNullCard() {
        final CardElement element = new CardElement();
        element.setMouseListener(new IMouseAdapter(){
            @Override
            public void onMouseClick(MouseState mouse) {
                error();
            }

            @Override
            public void onMouseEnter(MouseState mouse) {
                error();
            }

            @Override
            public void onMouseExit(MouseState mouse) {
                error();
            }

            @Override
            public void onMouseMove(MouseState mouse) {
                error();
            }

            @Override
            public void onMouseRelease(MouseState state) {
                error();
            }

            @Override
            public void onMouseRightClick(MouseState state) {
                error();
            }

            private void error() {
                Logger.getGlobal().warning("didn't find element with this id");
            }
        });
        return element;
    }

    public static final CardElement NULL = genNullCard();
}