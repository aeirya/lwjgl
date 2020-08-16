package com.bubble.gui;

import java.util.List;

import com.bubble.gui.element.IElement;
import com.bubble.opengl.Texture;
import com.bubble.std.Point;
import com.bubble.util.resource.TextureManager;
import com.bubble.util.resource.UiManager;

public class GuiRenderer extends Renderer implements IGuiRenderer {
    private final UiManager ui;

    public GuiRenderer(TextureManager textures) {
        super(textures);
        ui = new UiManager(textures);
    }

    @Override
    public void drawElement(IElement element) {
        element.renderComponent(this);
    }
    
    public void drawButton(IElement button) {
        final Texture tex = ui.getButtonTexture(button.getSize());
        g.drawElement(button.getPosition(), button.getSize(), tex, button.getColor());
    }
    
    public void drawPanel(IElement e) {
        g.drawElement(e.getPosition(), e.getSize(), getTexture(e), e.getColor());
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

    @Override
    public void drawText(String text, Point position, String font) {
        // TODO Auto-generated method stub
    }
}