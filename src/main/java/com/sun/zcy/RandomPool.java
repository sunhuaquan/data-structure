package com.sun.zcy;

import java.util.HashMap;
import java.util.Random;

/**
 * @author sunhuaquan
 * @Title: RandomPool
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/8 0:22
 */
public class RandomPool<K> {

    private HashMap<K, Integer> keyIndexMap = new HashMap<>();
    private HashMap<Integer, K> indexKeyMap = new HashMap<>();
    private int size = 0;


    public void insert(K key) {

        keyIndexMap.put(key, size);
        indexKeyMap.put(size, key);
        size++;
    }

    public void delete(K key) {
        if (!keyIndexMap.containsKey(key)) {
            throw new RuntimeException("key:" + key + "is not exists");
        }
        size--;
        //最后一个index对应的key
        K k = indexKeyMap.get(size);
        //key对应的index
        Integer integer = keyIndexMap.get(key);
        //key对应的index等于最后一个key
        indexKeyMap.put(integer, k);

    }

    public K getRandom() {
        Random random = new Random();
        int i = random.nextInt(size);
        return indexKeyMap.get(i);
    }
}
