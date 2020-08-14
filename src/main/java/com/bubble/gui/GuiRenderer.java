package com.bubble.gui;

import java.util.ArrayList;
import java.util.List;

import com.bubble.opengl.Texture;
import com.bubble.render.Graphics;
import com.bubble.util.resource.TextureManager;

public class GuiRenderer implements IGuiRenderer {
    private final Graphics g;
    private List<IElement> elements;
    private final TextureManager textures;

    public GuiRenderer() {
        g = new Graphics();
        elements = new ArrayList<>();
        textures = new TextureManager();
    }

    public void addElement(IElement e) {
        elements.add(e);
    }

    public void addElements(List <? extends IElement> e) {
        elements.addAll(e);
    }

    public void removeElement(IElement e) {
        elements.remove(e);
    }

    @Override
    public void drawElement(IElement element) {
        element.paintComponent(this);
    }

    public void drawButton(IElement button) {
        final Texture tex = textures.getTexture("button-lg");
        g.drawElement(button.getPosition(), button.getSize(), tex, button.getColor());
    }

    public void drawPanel(IElement e) {
        g.drawElement(e.getPosition(), e.getSize(), null, e.getColor());
    }

    public void render(IElement element) {
        drawElement(convert(element));
    }

    private IElement convert(IElement element) {
        return element; // i guess we don't need that :))
    }

    private void clear() {
        g.clear();
    }

    public void render() {
        clear();
        elements.forEach(this::render);
        g.render();
    }
}