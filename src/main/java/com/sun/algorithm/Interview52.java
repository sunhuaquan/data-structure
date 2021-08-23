package com.sun.algorithm;

import com.sun.util.ListNode;

public class Interview52 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1!=null||p2!=null){
            ListNode p = p1 == null ? p2 : p1;
            int count = 0;
            while (p != null) {
                p = p.next;
                count++;
            }
            if(p1==null){
                p1=headA;
                p2=headB;
                for (int i=0;i<count;i++){
                    p2=p2.next;
                }

            }
            else if(p2==null){
                p1=headA;
                p2=headB;
                for (int i=0;i<count;i++){
                    p1=p1.next;
                }
            }
        }else {
            p1=headA;
            p2=headB;
        }
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
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


        ListNode firstCommonNode = new Interview52().getIntersectionNode(one, two);
        System.out.println(firstCommonNode.val);
    }
}
