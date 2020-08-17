package com.bubble.std;

import java.util.LinkedList;

public class Queue<T> {

    private final LinkedList<T> items;

    public Queue() {
        items = new LinkedList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T next() {
        return items.removeFirst();
    }

    public boolean hasNext() {
        return ! items.isEmpty();
    }
}