package com.bubble;

import java.util.stream.Collectors;

import com.bubble.ui.menu.MenuLayout;

public class MenuLayoutT {
    public static void main(String[] args) {
        MenuLayout layout = new MenuLayout("./assets/layout/main.json");
        System.out.println(layout.flattened().map(e -> e.getType()).collect(Collectors.toList()));
        System.out.println(layout.flattened().map(e -> e.getText()).collect(Collectors.toList()));
    }
}