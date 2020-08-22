package com.bubble.util.resource;

import com.bubble.font2.Font;

public class FontLoader implements IResourceLoader<Font> {

    private float size;

    public FontLoader(float size) {
        this.size = size;
    }

    @Override
    public Font loadFile(String path) {
        return new Font(path, 1024, 1024, size);
    }
}

// not using this for now