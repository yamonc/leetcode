package com.base.sort.compare.nonExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-02 17:37
 * @Description 基数排序
 * @Version 1.0
 */
public class RadixSort {
    public void radixSort(int[] arr) {
        List<Integer>[] bucket = new ArrayList[10];
        //初始化bucket
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<>();
        }
        //找到最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //1,10,100，1000.。。用来求对应位的数字
        int divideNum = 1;
        while (max > 0) {
            //max 和num控制
            for (int num : arr) {
                //分配，将对应位置的数字分给对应的bucket
                bucket[(num/divideNum)%10].add(num);
            }
            divideNum *= 10;
            max/=10;
            int idx = 0;
            //收集 重新捡起数据
            for(List<Integer> list: bucket){
                for(int num:list){
                    arr[idx++] = num;
                }
                //收集结束之后，需要清空下次接着使用。
                list.clear();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {249, 994, 3399, 7898};
        new RadixSort().radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
