package com.test.lru;

import com.test.lru.LRUCache;

import java.util.*;


public class Solution {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        int resultLength = 0;
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                resultLength++;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;
        LRUCache cache = new LRUCache(k);
        for (int[] operator : operators) {
            switch (operator[0]) {
                case 1:
                    cache.put(operator[1], operator[2]);
                    break;
                case 2:
                    Integer value = cache.get(operator[1]);
                    results[index++] = value == null ? -1 : value;
            }
        }
        return results;

    }
}