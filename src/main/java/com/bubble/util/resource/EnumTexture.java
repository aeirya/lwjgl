package com.bubble.util.resource;

public enum EnumTexture {
    BUTTON_LG, BUTTON_MD, BUTTON_XS,
    CARD, MONSTER_BACKGROUND;

    public String get() {
        return get(this);
    }

    private String get(EnumTexture texture) {
        switch(texture) {
            case BUTTON_LG:
            return "button-lg";
            case BUTTON_XS:
            return "button-xs";
            case BUTTON_MD:
            return "button-md";
            case CARD:
            return "card";
            case MONSTER_BACKGROUND:
            return "minion";
            default:
            return null;
        }
    }
}
