package com.sun.test;

import com.sun.helper.FileOperation;
import com.sun.util.*;
import com.sun.zcy.QueueArray;
import com.sun.zcy.RandomPool;
import com.sun.zcy.StackArray;
import com.sun.zcy.Zcy;
import org.junit.Test;


public class Main {

    private static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

    }

    @Test
    public void testQueueArray() {

        QueueArray queueArray = new QueueArray(10);
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            queueArray.enqueue(i);
        }
        System.out.print(queueArray.dequeue() + " ");
        System.out.print(queueArray.dequeue() + " ");
        System.out.print("\n");
        for (int i = 5; i < 10; i++) {
            System.out.print(i + " ");
            queueArray.enqueue(i);
        }
        System.out.print("\n");
        while (!queueArray.isEmpty()) {
            System.out.print(queueArray.dequeue() + " ");
        }
    }

    @Test
    public void testStackArray() {

        StackArray stackArray = new StackArray(10);
        for (int i = 0; i < 5; i++) {
            stackArray.push(i);
        }
        System.out.print(stackArray.pop() + " ");
        System.out.print(stackArray.pop() + " ");
        System.out.print(stackArray.pop() + " ");
        for (int i = 5; i < 10; i++) {
            stackArray.push(i);
        }
        while (!stackArray.isEmpty()) {
            System.out.print(stackArray.pop() + " ");
        }
    }

    @Test
    public void testRandomPool() {

        RandomPool<String> randomPool = new RandomPool<>();
        for (int i = 1; i < 100; i++) {
            randomPool.insert(i + "");
        }
        for (int i = 1; i < 50; i++) {
            randomPool.delete(i + "");
        }
        for (int i = 1; i < 100; i++) {
            String random = randomPool.getRandom();
            System.out.print(random + " ");
        }
    }

    @Test
    public void testPrintMatrixZigZag() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Zcy.printMatrixZigZag(matrix);

    }

    @Test
    public void testFindNumInSortedMatrix() {

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean numInSortedMatrix = Zcy.findNumInSortedMatrix(matrix, 20);
        System.out.print(numInSortedMatrix);
    }

    @Test
    public void testIsPalindromeList() {

        Node node = new Node(new int[]{1, 2, 3});

        boolean palindromeList = Zcy.isPalindromeList(node);
        System.out.println(palindromeList);
    }

    @Test
    public void testListPartition2() {

        Node node = new Node(new int[]{45, 1, 2, 3, 12, 45, 32, 56, 43, 76, 43, 65, 32, 45});

        Node node1 = Zcy.listPartition2(node, 45);
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }

    }
}
