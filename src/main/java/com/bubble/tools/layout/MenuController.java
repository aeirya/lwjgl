package com.bubble.tools.layout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuController {
    private final Map<String, List<MouseEvent>> eventMap;

    public MenuController() {
        eventMap = new HashMap<>();
    }

    public void loadMouseEvents(Map<String, List<MouseEvent>> eventMap) {
        eventMap.putAll(eventMap);
    }

    @FunctionalInterface
    interface IMouseEvent {
        void onEvent(MouseState e);
    }

    abstract class MouseEvent extends MouseState implements IMouseEvent {
        private MouseEventType type;
    }

    enum MouseEventType {
        CLICK, ENTER, EXIT, DRAG
    }

    class MouseState {
        private int x;
        private int y;
        private boolean isClicked;
    }
}
