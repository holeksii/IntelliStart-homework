package com.intellias.collections;

public interface Collection<T> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(T item);
    boolean remove(Object o);
    void clear();
}
