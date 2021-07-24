package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: Node
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/810:04
 */
public class Node<E> {

    private E value;
    private Node next;

    public Node() {

    }

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();
        Node<E> node=this;
        while (node!=null){

            sb.append(node.getValue()).append("->");

            node=node.getNext();
        }
        return sb.toString();
    }
}
