package com.bubble.input.keyboard;

public interface IKeyCharTypeListener extends IKeyAdapter
{
    @Override
    default void onCharCallback(int codepoint) {
        onType(codepoint);
    }

    void onType(int codepoint);
}