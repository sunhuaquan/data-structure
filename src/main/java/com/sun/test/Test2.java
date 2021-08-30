package com.sun.test;

import com.sun.util.ListNode;

import java.util.Stack;

public class Test2 {




    public ListNode generateListNode(int num){

        if(num<0){
            return null;
        }
        ListNode listNode=new ListNode(num);
        listNode.next=generateListNode(--num);
        return listNode;
    }



    public void printListNode(ListNode listNode){

         while (listNode!=null){
             System.out.print(listNode.val+" ");
             listNode=listNode.next;
         }
    }



    public static void main(String[] args){
        Test2 test2 = new Test2();
        ListNode listNode= test2.generateListNode(10);
        test2.printListNode(listNode);

    }
}
