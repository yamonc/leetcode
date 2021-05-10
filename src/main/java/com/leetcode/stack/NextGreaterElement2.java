package com.leetcode.stack;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-04-20 20:29
 * @Description
 * @Version 1.0
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack=new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
//        先处理nums2，把对应关系存入哈希表
        for (int i = 0;i<len2;i++){
            while (!stack.isEmpty() && stack.peekLast()<nums2[i]){
                map.put(stack.removeLast(), nums2[i]);

            }
            stack.addLast(nums2[i]);
        }
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2};
        int[] arr1 = {1,3,4,2};
        new NextGreaterElement2().nextGreaterElement(arr,arr1);


    }
}
