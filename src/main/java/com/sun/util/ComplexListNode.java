package com.sun.util;

public class ComplexListNode<E> {

    private E val;

    ComplexListNode<E> next;

    ComplexListNode<E> sibling;

    public ComplexListNode(E val) {
        this.val = val;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public ComplexListNode<E> getNext() {
        return next;
    }

    public void setNext(ComplexListNode<E> next) {
        this.next = next;
    }

    public ComplexListNode<E> getSibling() {
        return sibling;
    }

    public void setSibling(ComplexListNode<E> sibling) {
        this.sibling = sibling;
    }

    @Override
    public String toString() {

        ComplexListNode node=this;
        StringBuilder sb=new StringBuilder();
        while (node!=null){
            sb.append(node.getVal());
            if(node.getSibling()!=null){
                sb.append(",").append(node.getSibling().getVal()).append("---->");
            }
            node=node.next;
        }
        return sb.toString();
    }
}
