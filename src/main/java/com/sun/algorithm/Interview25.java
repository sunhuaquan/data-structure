package com.sun.algorithm;


import com.sun.util.Node;

public class Interview25 {

    public static void main(String[] args) {

        Node<Integer> one=new Node<>(1);
        Node<Integer> three=new Node<>(3);
        Node<Integer> five=new Node<>(5);
        Node<Integer> seven=new Node<>(10);

        Node<Integer> two=new Node<>(2);
        Node<Integer> four=new Node<>(4);
        Node<Integer> sex=new Node<>(6);
        Node<Integer> eight=new Node<>(8);

        one.setNext(three);
        three.setNext(five);
        five.setNext(seven);

        two.setNext(four);
        four.setNext(sex);
        sex.setNext(eight);

        Node<Integer> merge = merge(one, two);

        System.out.println(merge);
    }

    public static Node<Integer> merge(Node<Integer> node1,Node<Integer> node2){

        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        Node<Integer> head=new Node<>();

        Node<Integer> p1=node1;
        Node<Integer> p2=node2;

        Node<Integer> curr=new Node<>();
        head=curr;
        while (p1!=null&&p2!=null){
              if(p1.getValue()<p2.getValue()){
                  curr.setNext(p1);
                  p1=p1.getNext();
              }else {
                  curr.setNext(p2);
                  p2=p2.getNext();
              }
              curr=curr.getNext();
        }
        while (p1!=null){
            curr.setNext(p1);
            p1=p1.getNext();
            curr=curr.getNext();
        }
        while (p2!=null){
            curr.setNext(p2);
            p2=p2.getNext();
            curr=curr.getNext();
        }
        return head.getNext();
    }


}
