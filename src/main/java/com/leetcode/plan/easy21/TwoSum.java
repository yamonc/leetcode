package com.leetcode.plan.easy21;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-06 15:42
 * @Description
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int ln = numbers[left];
            int rn = numbers[right];
            if(ln+rn==target){
                return new int[]{left+1, right+1};
            }else if(ln+rn>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] arr ={2,7,11,15};
        System.out.println(Arrays.toString(new TwoSum().twoSum(arr, 9)));
    }
}
