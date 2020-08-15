package com.bubble.gui;

import java.util.List;

import com.bubble.input.GameInput;
import com.bubble.input.keyboard.IKeyAdapter;
import com.bubble.input.keyboard.IKeyCharTypeListener;
import com.bubble.input.keyboard.IKeyEvent;
import com.bubble.input.keyboard.IKeyListener;

import org.lwjgl.glfw.GLFW;

public class GuiInputManager implements IGuiManager {
    
    private final IKeyListener keyListener;
    private IMenu currentMenu;
    private IElement active;

    public GuiInputManager() {
        keyListener = new IKeyAdapter(){
            @Override
            public void onCharCallback(int codePoint) {
                System.out.println(codePoint);
                final String typed = Character.toString(codePoint);
                System.out.println("typing: " + typed);
                if(active != null) {
                    if (active.getType().equals(ElementType.TEXTBOX)) {
                        active.addText(typed);
                        System.out.println("the textbox says: " + active.getText());   
                    }
                }
            }
            @Override
            public void onKeyPress(IKeyEvent event) {
                if (event.getKey() == GLFW.GLFW_KEY_BACKSPACE) {
                    System.out.println("back space!");
                    if (active != null) {
                        if (active.getType().equals(ElementType.TEXTBOX)) {
                            // new Textbox(active).backspace();
                            ((Textbox) active).backspace();
                            System.out.println("textbox text: " + active.getText());
                        }
                    }
                }
            }
        };
    }

    public void bind(GameInput input) {
        input.bindListener(keyListener);
        input.bindGuiManager(this);
    }

    public void launch(IMenu menu) {
        this.currentMenu = menu;
    }

    public void setActive(IElement element) {
        active = element;
    }
    
    public void clicked(IElement element) {
        setActive(element);
    }

    public IElement getActiveElement() {
        return active;
    }

    public List<IElement> getAllElementsOnScreen() {
        return currentMenu.getLayout().findAllElements();
    }
}