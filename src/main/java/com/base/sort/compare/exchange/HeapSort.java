package com.base.sort.compare.exchange;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-01 17:01
 * @Description
 * @Version 1.0
 */
public class HeapSort {
    /**
     * 交换数组arr中m和n的位置
     *
     * @param arr 待交换数组
     * @param m   数组下标为m
     * @param n   数组下标为n
     */
    public void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    /**
     * 用给定的数组创建成堆
     *
     * @param arr 给定的数组
     */
    public void createHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            shiftDown(arr, i, arr.length);
        }
    }

    /**
     * 下移交换，把当前节点有效变换成为一个堆（小根堆）
     *
     * @param arr   创建的数组
     * @param index 线标
     * @param len   长度
     */
    public void shiftDown(int[] arr, int index, int len) {
        //0号位置不需要
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        if (leftChild >= len) {
            return;
        } else if (rightChild < leftChild && arr[rightChild] < arr[index] && arr[rightChild] < arr[leftChild]) {
            //交换节点值
            swap(arr, index, rightChild);
            //可能会对孩子节点的堆有影响，向下重构
            shiftDown(arr, rightChild, len);
        } else if (arr[leftChild] < arr[index]) {
            //交换做孩子
            swap(arr, index, leftChild);
            shiftDown(arr, leftChild, len);
        }
    }

    public void heapSort(int[] arr){
        System.out.println("原数组为："+ Arrays.toString(arr));
        //临时存储结果
        int[] val = new int[arr.length];
        //建堆
        createHeap(arr);
        System.out.println("建立堆之后的序列为："+ Arrays.toString(arr));
        // 进行n次取值建堆，每次取堆顶元素放入val数组中，最终结果即为一个递增排序的序列
        for(int i = 0;i<arr.length;i++){
            //将堆顶放入结果中
            val[i] = arr[0];
            //删除堆顶元素，将末尾元素放到堆顶
            arr[0] = arr[arr.length-i-1];
            //将这个堆调整为合法的小根堆，主义长度上的变化
            shiftDown(arr, 0, arr.length-i);
        }
        //数值克隆
        for(int i = 0;i<arr.length;i++){
            arr[i] = val[i];
        }
        System.out.println("堆排序后的序列为:"+Arrays.toString(arr));
    }


}
