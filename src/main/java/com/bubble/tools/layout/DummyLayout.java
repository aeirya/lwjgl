package com.bubble.tools.layout;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.bubble.util.file.FileLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DummyLayout extends Layout {
    public DummyLayout() {
        elements = Arrays.asList(new LayoutElement("id", "panel", new Dimension(10, 20), new Position(1, 3),
                Arrays.asList(new DummyElement(), new DummyElement()), "text"));
    }

    public class DummyElement extends LayoutElement {
        public DummyElement() {
            super("id2", "button", new Dimension(2, 3), new Position(3, 2), null, "click");
        }
    }

    public static void main(String[] args) {
        write();
    }
    
    public static void write() {
        try (FileWriter fw = new FileWriter("file.txt")) {
            fw.write(
                new GsonBuilder().setPrettyPrinting().create().toJson(new DummyLayout())
            );
        } catch(IOException e) {
            //
        }
    }

    public static void load() {
        Layout layout =  new Gson().fromJson(new FileLoader("file.txt").load(), Layout.class);
        System.out.println(layout.toString());
    }
}