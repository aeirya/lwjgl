package com.bubble.gui;

import com.bubble.gui.element.MenuLayout;
import com.bubble.input.mouse.IMouseAdapter;

public interface IMenu extends IMouseAdapter {
    MenuLayout getLayout();
}
