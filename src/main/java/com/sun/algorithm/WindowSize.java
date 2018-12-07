package com.sun.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 18:18
 */
public class WindowSize {

    public static int[] windowMaxValue(int[] arr, int w) {

        LinkedList<Integer> queue = new LinkedList<>();
        if (arr.length < w) {
            throw new RuntimeException("w is illegal");
        }
        int[] result = new int[arr.length - w + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < w; i++) {
            queue.addFirst(arr[i]);
            max = Math.max(max, arr[i]);
        }
        result[0] = max;
        for (int i = 1; i < arr.length - w + 1; i++) {
            queue.addFirst(arr[i - 1 + w]);
            queue.removeLast();
            max = Integer.MIN_VALUE;
            for (int j = 0; j < w; j++) {
                max = Math.max(max, queue.get(j));
            }
            result[i] = max;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] result = windowMaxValue(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 4);
        for (int v : result) {
            System.out.println(v);
        }

    }
}
