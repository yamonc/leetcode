package com.leetcode.compeet;

/**
 * @Author yamon
 * @Date 2021-04-11 10:41
 * @Description已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 *
 * 返回 signFunc(product) 。
 * @Version 1.0
 */
public class ArraySign {
    public int arraySign(int[] nums) {
        int count=0;
        int mCount=0;
        for (int num : nums) {
            if (num==0){
                return 0;
            }else if (num>0){
                count++;
            }else{
                mCount++;
            }
        }
        if (mCount%2==0){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,36,96,70,85,23,5,18,4,12,89,92,9,30,53,14,96,32,13,43,37,60,75,7,83,68,20,8,-24,-80,-27,-92,-96,-20,-16,-52,-49,-38};
        System.out.println(new ArraySign().arraySign(nums));
    }
}
