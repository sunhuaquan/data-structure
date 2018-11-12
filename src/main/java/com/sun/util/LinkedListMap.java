package com.sun.util;

public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyNode;
    private int size;

    public LinkedListMap() {

        dummyNode = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyNode.next = new Node(key, value, dummyNode.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {

        Node prvNode = dummyNode.next;
        while (prvNode.next != null) {
            if (prvNode.next.key.equals(key)) {
                Node delNode = prvNode.next;
                prvNode.next = prvNode.next.next;
                delNode.next = null;
                return delNode.value;
            }
            prvNode = prvNode.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    private Node getNode(K key) {

        Node node = dummyNode.next;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null)
            throw new RuntimeException(key + " is not exist in map");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
}
