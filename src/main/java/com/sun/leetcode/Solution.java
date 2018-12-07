package com.sun.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] arr) {

            this.val = arr[0];
            this.next = builderNext(arr, 1);
        }

        public ListNode builderNext(int[] arr, int index) {

            if (index > arr.length - 1) return null;
            if (index == arr.length - 1) {
                ListNode node = new ListNode(arr[index]);
                node.next = null;
                return node;
            }
            ListNode node = new ListNode(arr[index]);
            node.next = builderNext(arr, index + 1);
            return node;
        }

        @Override
        public String toString() {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            ListNode node = this;

            while (node != null) {
                stringBuilder.append(node.val).append(",");
                node = node.next;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode node = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (node != null) {
            map.put(index, node);
            node = node.next;
            index++;
        }
        return map.get(index / 2);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode headNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return headNode;
        }
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] code = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new TreeSet<>();
        StringBuilder sb;
        for (String str : words) {
            sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                sb.append(code[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int v : nums1) {
            set.add(v);
        }
        for (int v : nums2) {
            boolean add = set.add(v);
            if (!add) {
                list.add(v);
            }
        }
        int[] res = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        return 0;
    }


    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    public void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public void shellSort(int[] nums) {
        for (int grap = nums.length / 2; grap > 0; grap /= 2) {
            //插入排序
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + grap; j < nums.length; j += grap) {
                    int curr = nums[j];
                    int index = j - grap;
                    while (index >= 0 && nums[index] > curr) {
                        nums[j] = nums[index];
                        index = index - grap;
                    }
                    nums[index + grap] = curr;
                }
            }
        }
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        throw new RuntimeException("the solution is not solution");

    }

    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase().replace(" ", "");
        int left = 0;
        int right = temp.length() - 1;
        while (left < right) {
            char leftChar = temp.charAt(left);
            if (!isNumberOrLetter(leftChar)) {
                left++;
                continue;
            }
            char rightChar = temp.charAt(right);
            if (!isNumberOrLetter(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isNumberOrLetter(char c) {

        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int right = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                sum += nums[++right];
            } else {
                sum -= nums[left++];
            }
            if (sum >= s) {
                res = Math.min(res, right - left + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public int lengthOfLongestSubstring(String s) {
       //滑动窗口[l...r]
        int l = 0, r = -1;
        int res = 0;
        int[] arr = new int[256];
        while (l < s.length()) {
            //第r+1个字符不在滑动窗口里面
            if (r + 1 < s.length() && arr[s.charAt(r + 1)] == 0) {
                arr[s.charAt(++r)] = 1;
                res = Math.max(res, r - l + 1);
            } else {//第r+1个字符在滑动窗口里面
                arr[s.charAt(l++)] = 0;
            }
        }
        return res;
    }

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        for (int i = 0; i * i < n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                return i != 0 && j != 0 ? 2 : 1;
            }
        }
        return 3;
    }

    class Pair {
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Integer key;
        public Integer value;
    }


    public static void main(String[] args) {


        int[] nums = new int[]{1};


        // System.out.println(obj.sumRange(0, 2));


    }
}
