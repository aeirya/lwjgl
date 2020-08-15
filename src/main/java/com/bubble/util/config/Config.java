package com.bubble.util.config;

import java.util.EnumMap;
import java.util.Map;

public class Config {

    private static final Config instance = new Config();
    private final Map<AssetType, String> assets;

    private Config() {
        assets = new EnumMap<>(AssetType.class);   
        setPath("assets/");
    }

    public static void load(String path) {
        instance.setPath(path);
    }
    
    private void setPath(String path) {
        assets.clear();
        final String sep = "/";
        for (AssetType type : AssetType.values()) {
            assets.put(type, path + sep + type.toString() + sep);
        }
    }

    private enum AssetType {
        SHADER, LAYOUT, TEXTURE, CONFIG;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public static String getShaderPath() {
        return instance.assets.get(AssetType.SHADER);
    }
    
    public static String getLayoutPath() {
        return instance.assets.get(AssetType.LAYOUT);
    }

    public static String getTexturePath() {
        return instance.assets.get(AssetType.TEXTURE);
    }

    public static String getConfigPath() {
        return instance.assets.get(AssetType.CONFIG);
    }
}