package com.bubble.util.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface IResourceLoader<T> {

    public default Map<String, T> loadDir(String dir) {
        final Map<String, T> map = new HashMap<>();
        listFiles(dir).forEach(
            file -> map.put(getFileName(file), loadFile(file.getPath()))
        );
        return map;
    }

    public default Map<String, T> loadDir(String dir, boolean loadSub) {
        if (!loadSub) return loadDir(dir);
        else {
            final Map<String, T> map = loadDir(dir);
            listDirs(dir).forEach(d -> map.putAll(loadDir(d)));
            return map;
        }
    }

    private String getFileName(File file) {
        return file.getName().split("\\.")[0];
    }

    private List<File> listFiles(String path) {
        final File dir = new File(
            path
        );
        File[] files = dir.listFiles();
        if (files.length > 0) return Arrays.asList(files);
        else return new ArrayList<>();
    }
        
    public abstract T loadFile(String path);

    private List<String> listDirs(String path) {
        File file = new File(path);
        String[] directories = file.list(
            (current, name) -> new File(current, name).isDirectory()
        );
        if(directories.length == 0) return new ArrayList<>();
        else return Arrays.asList(directories).stream().map(d -> path + d).collect(Collectors.toList());
    }
}