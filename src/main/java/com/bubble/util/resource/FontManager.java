
package com.bubble.util.resource;

import java.io.File;
import java.util.Arrays;

import com.bubble.font2.Font;

public class FontManager {

    private static final String FONT_PATH = "assets/fonts/";

    private FontManager() {

    }

    private static String getFontPath(String fontName) {
        return Arrays.asList(new File(FONT_PATH).listFiles())
            .stream()
            .filter(f -> f.getName().contains(fontName))
            .map(File::getAbsolutePath)
            .findFirst().orElse(null);
    }

    public static  Font loadFont(String name, float size) {
        return new Font(getFontPath(name), 1024, 1024, size);
    }
}