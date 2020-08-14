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
        final Texture tex = (button.getSize().height > button.getSize().width * 1.5f) ? 
            textures.getTexture("button-xs") : (button.getSize().height * 3 <= button.getSize().width) ?
            textures.getTexture("button-lg") : textures.getTexture("button-md");
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

    private void clearMemory() {
        g.clear();
    }

    public void render() {
        elements.forEach(this::render);
        g.render();
        clearMemory();
    }
}