package com.sun.algorithm;

import com.sun.data.Node;

import java.util.Stack;

public class Interview6 {


    public static void main(String[] args){
        Node head=new Node(1);

        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(head);
        printListReverse(head);

    }

    public static void printListReverse(Node head){

        if(head!=null&&head.getNext()!=null){
            printListReverse(head.getNext());
        }
        System.out.println(head.getVal());
    }
}
