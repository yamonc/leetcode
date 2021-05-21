package com.leetcode.sort;

/**
 * @Author yamon
 * @Date 2021-05-20 20:33
 * @Description
 * @Version 1.0
 */
public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity){
        a = new int[capacity+1];
        n = capacity;
        count=0;
    }
    public void insert(int data){
        if (count>n){
            return;
        }
        ++count;
        a[count]=data;

    }
}
