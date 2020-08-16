package com.bubble.graphics;

import com.bubble.gui.GuiRenderer;
import com.bubble.gui.IGuiManager;
import com.bubble.gui.IGuiRenderer;
import com.bubble.gui.card.legacy.CardRenderer;
import com.bubble.render.IRenderer;
import com.bubble.util.resource.TextureManager;

public class GameRenderer implements IRenderer {
    private final TextureManager textures;
    private final IGuiRenderer guiRenderer;
    private final CardRenderer cardRenderer;
    private final IGuiManager gui;

    public GameRenderer(IGuiManager gui) {
        this.gui = gui;
        textures = new TextureManager();
        guiRenderer = new GuiRenderer(textures);
        cardRenderer = new CardRenderer(textures);
    }

    public void render() {
        renderGui();
        renderCards();
    }
    
    private void renderGui() {
        guiRenderer.render(gui.getAllElementsOnScreen());
        guiRenderer.render();
    }

    private void renderCards() {
        cardRenderer.render(gui.getPlayerHand());
        cardRenderer.render();
    }
}