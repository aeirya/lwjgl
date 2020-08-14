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
    private final UiManager ui;

    public GuiRenderer() {
        g = new Graphics();
        elements = new ArrayList<>();
        textures = new TextureManager();
        ui = new UiManager(textures);
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
        final Texture tex = ui.getButtonTexture(button.getSize());
        g.drawElement(button.getPosition(), button.getSize(), tex, button.getColor());
    }

    public void drawPanel(IElement e) {
        g.drawElement(e.getPosition(), e.getSize(), getTexture(e), e.getColor());
        // g.drawRect(e.getPosition(), e.getSize(), e.getColor());
    }

    private Texture getTexture(IElement e) {
        return textures.getTexture(e.getTexture());
    }

    public void render(IElement element) {
        drawElement(convert(element));
    }

    private IElement convert(IElement element) {
        return element; // i guess we don't need that :))
    }

    private void clearMemory() {
        g.clear();
    }

    public void render() {
        elements.forEach(this::render);
        g.render();
        clearMemory();
    }
}