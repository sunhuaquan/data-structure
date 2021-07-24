package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: Node
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/810:04
 */
public class DuLNode<E> {

    private E value;
    private DuLNode prv;
    private DuLNode next;

    public DuLNode() {

    }

    public DuLNode(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public DuLNode getPrv() {
        return prv;
    }

    public void setPrv(DuLNode prv) {
        this.prv = prv;
    }

    public DuLNode getNext() {
        return next;
    }

    public void setNext(DuLNode next) {
        this.next = next;
    }
}
