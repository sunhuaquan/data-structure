package com.sun.data;

public class Node {

    private int val;

    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append(this.val);
        Node node=this;
        while (node.next!=null){
            s.append("--->"+node.next.val);
            node=node.next;
        }
        return s.toString();
    }
}
