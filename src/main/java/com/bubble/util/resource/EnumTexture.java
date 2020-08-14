package com.bubble.util.resource;

public enum EnumTexture {
    BUTTON_BIG, BUTTON_MED, BUTTON_SMALL;

    public String get() {
        return get(this);
    }

    private String get(EnumTexture texture) {
        switch(texture) {
            case BUTTON_BIG:
            return "button-lg";
            case BUTTON_SMALL:
            return "button-xs";
            case BUTTON_MED:
            return "button-md";
            default:
            return null;
        }
    }
}
