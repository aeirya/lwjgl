package com.bubble.ui.menu;

import java.util.List;

import com.bubble.input.mouse.IMouseAdapter;
import com.bubble.ui.element.IElement;

public interface IMenu extends IMouseAdapter {
    MenuLayout getLayout();
    List<IElement> getAllElementsOnScreen();
}
