package com.bubble.ui;

import com.bubble.font2.Font;
import com.bubble.font2.TextRenderer;
import com.bubble.render.IRenderer;
import com.bubble.render.Shader;
import com.bubble.std.Math;
import com.bubble.ui.card.legacy.CardRenderer;
import com.bubble.ui.element.Align;
import com.bubble.ui.element.ElementType;
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
                float scale = 0.0017f;
                if (e.getText() == null) return;
                if (e.getFont() != null) textRenderer.setFont(e.getFont());
                float x;
                if (e.getAlign() == Align.CENTER) x = e.getPosition().x + e.getSize().width / 2 - Math.getTextWidth(e.getText(), scale, e.getFont()) / 2;
                else x = e.getPosition().x + 0.01f * e.getSize().width;
                float y;
                if (e.getAlign() == Align.TOP_LEFT) y = e.getPosition().y - e.getFont().getSize() * scale / 4;
                else y = e.getPosition().y - e.getSize().height / 2 - e.getFont().getSize() * scale / 4;
                if (e.getType() == ElementType.TEXT_AREA)
                    textRenderer.drawMultilineText(
                        e.getText(), 
                        x, 
                        y, 
                        scale, 1, 1, 1, 1, e.getSize().width * 0.9f, true, false);
                else 
                    textRenderer.drawText(
                        e.getText(),
                        x, 
                        y,
                        scale,
                        1, 1, 1, 1, 
                        e.getSize().width - 0.08f, 
                        true);
                textRenderer.setFont(Font.GRAND_HOTEL_REGULAR); // swap with reset function
            }
        );
    }
}