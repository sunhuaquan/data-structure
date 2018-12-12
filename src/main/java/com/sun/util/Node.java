package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: Node
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/810:04
 */
public class Node {

    public int value;
    public Node next;

    public Node() {

    }

    public Node(int value) {
        this(value, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int[] arr) {
       /* if (arr != null && arr.length > 0) {
            this.value = arr[0];
        }
        Node prv = this;
        for (int i = 1; i < arr.length; i++) {
            Node curr = new Node(arr[i]);
            prv.next = curr;
            prv = prv.next;
        }*/
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is empty");
        }
        this.value = arr[0];
        this.next = builderFrom(arr, 1);
    }

    private Node builderFrom(int[] arr, int i) {

        if (i >= arr.length) {
            return null;
        }
        Node node = new Node(arr[i]);
        node.next = builderFrom(arr, i + 1);
        return node;
    }

}
