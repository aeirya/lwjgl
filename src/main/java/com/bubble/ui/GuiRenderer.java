package com.bubble.ui;

import java.util.List;
import java.util.logging.Logger;

import com.bubble.font2.TextRenderer;
import com.bubble.opengl.Texture;
import com.bubble.render.Renderer;
import com.bubble.render.Shader;
import com.bubble.ui.element.IElement;
import com.bubble.util.resource.TextureManager;
import com.bubble.util.resource.UiManager;

public class GuiRenderer extends Renderer implements IGuiRenderer {
    private final UiManager ui;
    private final TextRenderer textRenderer;

    public GuiRenderer(TextureManager textures, TextRenderer textRenderer) {
        super(textures);
        ui = new UiManager(textures);
        this.textRenderer = textRenderer;
    }

    @Override
    public void drawElement(IElement element) {
        if (element.isHidden()) return;
        
        element.renderComponent(g);
        
        switch(element.getType()) {
            case BUTTON:
            drawButton(element);
            break;

            case PANEL:
            drawPanel(element);
            break;

            case TEXTBOX:
            drawTextbox(element);
            break;

            default:
            Logger.getLogger("gui renderer").warning("not rendering");
            break;
        }

        if (element.getChildren() != null) {
            element.getChildren().forEach(c -> c.renderComponent(g));
        }

    }
    
    public void drawButton(IElement button) {
        final Texture tex = ui.getButtonTexture(button.getSize());
        g.drawElement(button.getPosition(), button.getSize(), tex, button.getColor());
        textRenderer.drawText(
                button.getText(),
                button.getPosition().x + button.getSize().width / 4,
                button.getPosition().y + button.getSize().height, 
                0.002f, 
                1, 1, 1, 1, true);
    }
    
    public void drawPanel(IElement e) {
        g.drawElement(e.getPosition(), e.getSize(), getTexture(e), e.getColor());
    }

    private void drawTextbox(IElement e) {
        drawPanel(e);
        g.drawText(e.getText(), e.getPosition(), 32, e.getFont());
    }

    private Texture getTexture(IElement e) {
        return textures.getTexture(e.getTexture());
    }

    public void render(IElement element) {
        drawElement(element);
    }

    public void render(List<IElement> elements) {
        elements.forEach(this::render);
    }
}