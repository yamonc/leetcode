package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-28 15:03
 * @Description
 * @Version 1.0
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num:nums){
            n ^= num;
        }
        while ((n&m)==0){
            m<<=1;
        }
        for(int num:nums){
            if((num &m)!=0){
                x ^= num;
            }else{
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] arr = {4,1,4,6};
        new SingleNumbers().singleNumbers(arr);
    }
}
