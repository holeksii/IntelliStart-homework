package com.intellias.collections;

import java.util.Objects;

public class HashMap<K, V> {
    Node<K, V> head;
    private int size;

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);

        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> current = head;
            while (current.next != null) {
                if (current.key.equals(key)) {
                    V oldValue = current.value;
                    current.value = value;
                    return oldValue;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return null;
    }

    public V remove(K key) {
        if (head == null) {
            return null;
        }

        if (head.key.equals(key)) {
            V oldValue = head.value;
            head = head.next;
            size--;
            return oldValue;
        }

        Node<K, V> current = head;
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                V oldValue = current.next.value;
                current.next = current.next.next;
                size--;
                return oldValue;
            }
            current = current.next;
        }
        return null;
    }

    public void clear() {
        Node<K, V> current = head;
        while (current != null) {
            Node<K, V> next = current.next;
            current.next = null;
            current = next;
        }
        head = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public V get(K key) {
        Node<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Node<?, ?> e) {
                return Objects.equals(key, e.key) &&
                        Objects.equals(value, e.value);
            }
            return false;
        }
    }
}
