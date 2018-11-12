package com.sun.test;

import com.sun.util.Merger;
import com.sun.util.SegmentTree;

public class SegmentTreeTest {

    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        SegmentTree<Integer> segmentTree = new SegmentTree(nums, new Merger<Integer>() {

            @Override
            public Integer merge(Integer data1, Integer data2) {
                return data1 + data2;
            }
        });
        segmentTree.set(1, 10);
        Integer query = segmentTree.query(0, 2);

        System.out.println("---------------" + query);
    }
}
