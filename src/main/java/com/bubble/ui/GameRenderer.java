package com.bubble.ui;

import com.bubble.font2.Font;
import com.bubble.font2.TextRenderer;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;
import com.bubble.ui.card.legacy.CardRenderer;
import com.bubble.ui.management.IGuiManager;
import com.bubble.util.resource.TextureManager;

public class GameRenderer implements IRenderer {
    private final TextureManager textures;
    private final IGuiRenderer guiRenderer;
    private final CardRenderer cardRenderer;
    private final IGuiManager gui;
    private final TextRenderer textRenderer;

    public GameRenderer(IGuiManager gui) {
        this.gui = gui;
        Shader.initiateShaders();
        textures = new TextureManager();
        textRenderer = setupTextRenderer();
        guiRenderer = new GuiRenderer(textures, textRenderer);
        cardRenderer = new CardRenderer(textures);
    }

    private TextRenderer setupTextRenderer() {
        TextRenderer t = new TextRenderer(Shader.getFontShader());
        t.setFont(Font.GRAND_HOTEL_REGULAR);
        return t;
    }

    public void render() {
        renderGui();
        renderCards();
        renderTexts();
    }
    
    private void renderGui() {
        guiRenderer.render(gui.getAllElementsOnScreen());
        guiRenderer.render();
    }

    private void renderCards() {
        // cardRenderer.render(gui.getPlayerHand());
        cardRenderer.render();
    }

    private void renderTexts() {
        gui.getAllElementsOnScreen().forEach(
            e -> {
                if (e.getText() == null) return;
                if (e.getFont() != null) textRenderer.setFont(e.getFont());
                textRenderer.drawMultilineText(
                    e.getText(), 
                    e.getPosition().x + e.getSize().width / 4, 
                    e.getPosition().y - e.getSize().height / 2, 
                    0.0017f, 1, 1, 1, 1, 1f, true, false);
                textRenderer.setFont(Font.GRAND_HOTEL_REGULAR); // swap with reset function
            }
        );
    }
}