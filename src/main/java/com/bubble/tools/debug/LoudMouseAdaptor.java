package com.bubble.tools.debug;

import java.util.logging.Logger;

import com.bubble.input.mouse.IMouseListener;
import com.bubble.input.mouse.MouseState;

public class LoudMouseAdaptor implements IMouseListener {

    private final String msg;

    public LoudMouseAdaptor(String msg) {
        this.msg = msg;
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        error();
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        error();
    }

    @Override
    public void onMouseExit(MouseState mouse) {
        error();
    }

    @Override
    public void onMouseEnter(MouseState mouse) {
        error();
    }

    @Override
    public void onMouseRelease(MouseState state) {
        error();
    }

    @Override
    public void onMouseDrag(MouseState state) {
        error();
    }

    @Override
    public void onMouseRightClick(MouseState state) {
        error();
    }

    private void error() {
        Logger.getLogger("loudmouseadaptor").warning(msg);
    }
}