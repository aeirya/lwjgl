package com.bubble.util.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.bubble.util.file.FileLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// i could be replacing json with properties
public class GameConfig {
    private static class InstanceHolder {
        private static final GameConfig instance = new GameConfig();
    }

    private static GameConfig getInstance() {
        return InstanceHolder.instance;
    }

    private static final String CONFIG_FILE = "config.json";

    private final Fields fields;

    private GameConfig() {
        this(Config.getConfigPath() + CONFIG_FILE);
    }

    private GameConfig(String path) {
        fields = load(path);
    }

    private Fields load(String path) {
        final Fields f = new Gson()
            .fromJson(new FileLoader(path).load(), Fields.class);
        if (f == null) {
            createSave(path);
            return new Fields();
        } else return f;
    }

    private void createSave(String path) {
        try(FileWriter fw = new FileWriter(new File(path))) {
            fw.write(
                new GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(new Fields()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Screen getScreen() {
        return getInstance().fields.getScreen();
    }

    private static class Fields {
        private final Screen screen;

        private Fields() {
            screen = new Screen();
        }

        private Screen getScreen() {
            if (screen != null)
                return screen;
            else return new Screen();
        }
    }

    public static class Screen {
        ScreenSize screensize;
        AspectRatio ratio;
        int fps;

        Screen() {
            screensize = new ScreenSize();
            ratio = new AspectRatio();
            fps = 30;
        }

        public ScreenSize getSize() {
            return screensize != null ?  screensize : new ScreenSize();
        }

        public AspectRatio getRatio() {
            return ratio != null ? ratio : new AspectRatio();
        }

        public int getRefreshWait() {
            return 1000 / fps;
        }
    }

    public static class AspectRatio {
        public final int W;
        public final int H;

        private AspectRatio(int n, int d) {
            this.W = n;
            this.H = d;
        }

        private AspectRatio() { this(3, 2); }
    }

    public static class ScreenSize {
        int width;
        int height;

        private ScreenSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        private ScreenSize() { this(1080, 720); }

        public int getWidth() { return width; }
        
        public int getHeight() { return height; }
    }
}