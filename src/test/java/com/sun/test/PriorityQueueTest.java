package com.sun.test;

import com.sun.util.PriorityQueue;

import java.util.Random;

public class PriorityQueueTest {

    public static void main(String[] args) {

        int n = 10;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++)
            priorityQueue.enqueue(random.nextInt(100));


        while (!priorityQueue.isEmpty())
            System.out.print(priorityQueue.dequeue() + " ");


    }
}
