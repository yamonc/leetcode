package com.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-05-07 19:40
 * @Description
 * @Version 1.0
 */
public class Intersection22 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        //结果
        int[] intersection = new int[nums1.length];
        int index=0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count>0){
                intersection[index++]=num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else{
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 5, 4, 4};
        int[] arr2 = {9, 4, 9, 8, 4, 6};
        new Intersection22().intersect(arr, arr2);
    }
}
