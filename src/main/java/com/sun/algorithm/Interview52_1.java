package com.sun.algorithm;

import com.sun.util.ListNode;

import java.util.Stack;

public class Interview52_1 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {


        ListNode one = new ListNode(1);
       ListNode two = new ListNode(2);
       /*  ListNode three = new ListNode(3);

        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        ListNode six = new ListNode(6);
        ListNode eleven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = six;
        six.next = eleven;

        four.next = five;
        five.next = six;*/
        ListNode firstCommonNode = new Interview52_1().getIntersectionNode(one, two);
        System.out.println(firstCommonNode);
    }
}
