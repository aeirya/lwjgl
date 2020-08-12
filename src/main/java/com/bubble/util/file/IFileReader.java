package com.bubble.util.file;

public interface IFileReader<T> {
    T load(String path);
}