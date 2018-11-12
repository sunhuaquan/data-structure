package com.sun.test;

import com.sun.util.ArrayList;
import com.sun.util.List;

public class MyArrayListTest {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
        System.out.println(myList);

        for(int v:myList)
            System.out.print(v+" ");
    }
}
