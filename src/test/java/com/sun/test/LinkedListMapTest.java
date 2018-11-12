package com.sun.test;

import com.sun.util.LinkedListMap;
import com.sun.util.Map;

public class LinkedListMapTest {

    public static void main(String[] args) {

        Map<String, Integer> map = new LinkedListMap<>();
        for (int i = 0; i < 10; i++) {
            map.add(i + "", i);
        }
        map.remove("2");
        map.set("1", 1000);
        for (int i = 0; i < 10; i++) {
            Integer integer = map.get(i + "");
            System.out.print(integer + " ");
        }
    }
}
