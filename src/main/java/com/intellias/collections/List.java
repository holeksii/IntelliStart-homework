package com.intellias.collections;

public interface List<T> extends Collection<T> {
    int size();
    int indexOf(Object o);
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(T item);
    boolean remove(Object o);
    void clear();
    void add(int index, T item);
    T get(int index);
    T remove(int index);
}
