package com.sun.leetcode;

public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {

        if (nums.length < 1) return;
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            data[i] = nums[i];
        segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
            @Override
            public Integer merge(Integer data1, Integer data2) {
                return data1 + data2;
            }
        });
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public class SegmentTree<E> {

        private E[] data;

        private E[] tree;

        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {

            this.merger = merger;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[4 * arr.length];
            builder(arr, 0, 0, arr.length - 1);

        }

        public void builder(E[] arr, int treeIndex, int left, int right) {

            if (left == right) {
                tree[treeIndex] = arr[left];
                return;
            }
            int mid = left + (right - left) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            builder(arr, leftChild, left, mid);
            builder(arr, rightChild, mid + 1, right);
            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
        }

        public E query(int left, int right) {

            return query(0, 0, data.length - 1, left, right);
        }

        public E query(int treeIndex, int treeLeft, int treeRight, int left, int right) {

            if (left == treeLeft && right == treeRight) {
                return tree[treeIndex];
            }
            int mid = treeLeft + (treeRight - treeLeft) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);

            if (left >= mid + 1)//右孩子中找
                return query(rightChild, mid + 1, treeRight, left, right);
            if (right <= mid)//左孩子中找
                return query(leftChild, treeLeft, mid, left, right);

            E leftResult = query(leftChild, treeLeft, mid, left, mid);//左边
            E rightResult = query(rightChild, mid + 1, treeRight, mid + 1, right);//右边

            return merger.merge(leftResult, rightResult);
        }

        // 将index位置的值，更新为e
        public void set(int index, E e) {

            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("index is illegal");
            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        // 在以treeIndex为根的线段树中更新index的值为e
        private void set(int treeIndex, int l, int r, int index, E e) {

            if (l == r) {
                tree[treeIndex] = e;
                return;
            }
            int mid = l + (r - l) / 2;
            // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (index >= mid + 1)
                set(rightTreeIndex, mid + 1, r, index, e);
            else // index <= mid
                set(leftTreeIndex, l, mid, index, e);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }


        private int leftChild(int index) {
            return index * 2 + 1;
        }

        private int rightChild(int index) {
            return index * 2 + 2;
        }
    }

    public interface Merger<E> {

        public E merge(E data1, E data2);

    }
}
