package com.sun.algorithm;

import com.sun.data.Node;

public class Interview18 {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(head);

        deleteNode(head, node5);

        System.out.println(head);


    }


    private static void deleteNode(Node head, Node node) {

        if (head == null || node == null) {
            return;
        }
        //首节点
        if(head==node){
            head=node.getNext();
        }
        //未节点
        if(node.getNext()==null){

            Node curr=head;
            while (curr.getNext()!=node){
                curr=curr.getNext();
            }
            curr.setNext(null);
            return;
        }else {
            Node next = node.getNext();
            node.setVal(next.getVal());
            node.setNext(next.getNext());
            next=null;
        }
    }
}
