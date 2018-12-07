package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] arr) {
            this.val = arr[0];
            this.next = getNextNode(arr, 1);
        }

        private ListNode getNextNode(int[] arr, int index) {

            if (index > arr.length - 1) return null;
            if (index == arr.length - 1) {
                ListNode node = new ListNode(arr[index]);
                node.next = null;
                return node;
            }
            ListNode node = new ListNode(arr[index]);
            node.next = getNextNode(arr, index + 1);
            return node;
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append(this.val + "--->");
            ListNode node = this;
            while (node.next != null) {
                sb.append(node.next.val + "--->");
                node = node.next;

            }
            return sb.toString();
        }
    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            List<Integer> list1 = getNumber(l1);
            List<Integer> list2 = getNumber(l2);
            int size = list1.size() > list2.size() ? list2.size() : list1.size();
            List<Integer> result = new ArrayList<>();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                int sum = list1.get(i) + list2.get(i) + flag;
                if (sum >= 10) {
                    result.add(sum - 10);
                    flag = 1;
                } else {
                    result.add(sum);
                    flag = 0;
                }
            }
            if (list1.size() > list2.size()) {

                for (int i = size; i < list1.size(); i++) {
                    int sum = list1.get(i) + flag;
                    if (sum >= 10) {
                        result.add(sum - 10);
                        flag = 1;
                    } else {
                        result.add(sum);
                        flag = 0;
                    }
                }
            } else if (list1.size() < list2.size()) {

                for (int i = size; i < list2.size(); i++) {
                    int sum = list2.get(i) + flag;
                    if (sum >= 10) {
                        result.add(sum - 10);
                        flag = 1;
                    } else {
                        result.add(sum);
                        flag = 0;
                    }
                }
            }
            if (flag != 0) {
                result.add(flag);
            }

            return builder(result);
        }


        private ListNode builder(List<Integer> list) {

            ListNode listNode = new ListNode(list.get(0));
            listNode.next = builder(list, 1);
            return listNode;
        }

        private ListNode builder(List<Integer> list, int index) {

            if (index > list.size() - 1) return null;
            if (index == list.size() - 1) {
                ListNode listNode = new ListNode(list.get(index));
                listNode.next = null;
                return listNode;
            }
            ListNode listNode = new ListNode(list.get(index));
            listNode.next = builder(list, index + 1);
            return listNode;
        }

        private List<Integer> getNumber(ListNode node) {

            List<Integer> list = new ArrayList<>();
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
            return list;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = new int[]{9, 1, 6};
        ListNode node1 = new ListNode(arr);
        System.out.println("node1=" + node1);
        int[] arr2 = new int[]{0};
        ListNode node2 = new ListNode(arr2);
        System.out.println("node2=" + node2);

        ListNode listNode = solution.addTwoNumbers(node1, node2);
        System.out.println("result:" + listNode);

    }
}
