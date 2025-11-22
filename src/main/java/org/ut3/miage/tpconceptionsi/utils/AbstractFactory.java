package org.ut3.miage.tpconceptionsi.utils;

public interface AbstractFactory<T> {
    T create(String... args) throws IllegalArgumentException;
}
