package com.sun.test;

import com.sun.util.ListNode;

import java.util.ArrayList;

public class Test1 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null) {
            return null;
        }
        ListNode preNode = listNode;
        ListNode currNode = preNode.next;
        preNode.next=null;
        while (currNode != null) {
            ListNode next = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (preNode != null) {
            result.add(preNode.val);
            preNode = preNode.next;
        }
        return result;

    }

    public static void main(String[] ars) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        ListNode six = new ListNode(6);
        ListNode eleven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        ArrayList<Integer> integers = new Test1().printListFromTailToHead(one);
        System.out.println(integers);

    }
}
