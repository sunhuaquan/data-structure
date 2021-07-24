package com.sun.algorithm;


import com.sun.util.Node;

public class Interview22 {

    public static void main(String[] args) {

        Node<Integer> one=new Node<>(1);
        Node<Integer> two=new Node<>(2);
        Node<Integer> three=new Node<>(3);
        Node<Integer> four=new Node<>(4);
        Node<Integer> five=new Node<>(5);
        Node<Integer> sex=new Node<>(6);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(sex);
        Node<Integer> kthToTail = findKthToTail(one, 6);

        System.out.println(kthToTail.getValue());

    }

   public static Node<Integer> findKthToTail(Node<Integer> node,int k){

        if(node==null||k==0){
            return null;
        }
        Node<Integer> p1=node;
        Node<Integer> p2=node;
        for (int i=0;i<k;i++){
            if(p2.getNext()!=null){
                p2=p2.getNext();
            }else {
                return null;
            }
        }
        while (p2!=null){
            p2=p2.getNext();
            p1=p1.getNext();
        }
        return p1;
   }
}
