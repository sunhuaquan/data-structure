package com.sun.algorithm;

import com.sun.data.Node;

public class Interview24 {

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
        Node reverse = reverseList(head);
        System.out.println(reverse);

    }



    public static Node reverseList(Node head){

        if(head==null){
            return head;
        }
        Node reverseHead=null;
        Node curr=head;
        Node prv=null;
        while (curr!=null){

            Node next=curr.getNext();
            if(next==null){
                reverseHead=curr;
            }
            curr.setNext(prv);
            prv=curr;
            curr=next;
        }
        return reverseHead;
    }



}
