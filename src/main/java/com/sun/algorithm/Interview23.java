package com.sun.algorithm;


import com.sun.util.Node;

public class Interview23 {

    public static void main(String[] args) {

        Node<Integer> one=new Node<>(1);
        Node<Integer> two=new Node<>(2);
        Node<Integer> three=new Node<>(3);
        Node<Integer> four=new Node<>(4);
        Node<Integer> five=new Node<>(5);
        Node<Integer> six=new Node<>(6);
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(three);

        Node<Integer> integerNode = entryNodeOfLoop(one);

       System.out.println(integerNode.getValue());

    }

    public static Node<Integer> entryNodeOfLoop(Node<Integer> head){

        Node<Integer> meetingNode = meetingNode(head);
        if(meetingNode==null){
            return null;
        }
        Node<Integer> curr=meetingNode;
        int index=0;
        while (curr!=null){
            curr=curr.getNext();
            index++;
            if(curr==meetingNode){
               break;
            }
        }
        Node<Integer> p1=head;
        Node<Integer> p2=head;
        for (int i=0;i<index;i++){
            p2=p2.getNext();
        }
        while (p1!=p2){
            p1=p1.getNext();
            p2=p2.getNext();
        }
        return p1;
    }


    public static Node<Integer> meetingNode(Node<Integer> head){

        if(head==null){
            return null;
        }
        Node<Integer> p1=head;
        Node<Integer> p2=head;
        while (p2!=null&&p2.getNext()!=null){
            p2=p2.getNext().getNext();
            p1=p1.getNext();
            if(p1==p2){
                return p1;
            }
        }
        return null;
    }


}
