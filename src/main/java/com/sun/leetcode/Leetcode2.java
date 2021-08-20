package com.sun.leetcode;

import com.sun.util.ListNode;

import java.util.List;

public class Leetcode2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre=new ListNode();
        ListNode currNode=pre;
        int curry=0;
        while(l1!=null||l2!=null){

            int v1=l1==null?0:l1.val;
            int v2=l2==null?0:l2.val;
            int sum=v1+v2+curry;

            curry=sum/10;
            sum=sum%10;
            currNode.next=new ListNode(sum);
            currNode=currNode.next;

            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(curry!=0){
            currNode.next=new ListNode(curry);
        }
        return pre.next;
    }

    public static void main(String[] args) {

    }
}
