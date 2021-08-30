package com.sun.algorithm;


import java.util.*;

public class Interview59 {


    public static void main(String[] args) {

        System.out.println(null==null);
        List<Integer> integers = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(integers);

    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < 0 || num.length < size) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - size + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i >= size) {
                res.add(num[deque.peek()]);
            }
        }
        return res;

    }


}
