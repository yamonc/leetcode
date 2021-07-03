package com.labuladong.highFrequencyInterview;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-02 16:28
 * @Description 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        //寻找重复元素
        for(int i = 0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            //nums[index]<0 证明有重复访问
            if(nums[index]<0){
                dup = Math.abs(nums[i]);
            }else{
                nums[index] *= -1;
            }
        }
        //查找缺失元素
        int missing = -1;
        for(int i = 0;i<n;i++){
            //nums[i] >0 则说明没有方位
            if(nums[i]>0){
                missing = i+1;
            }
        }
        return new int[]{dup, missing};
    }

    public static void main(String[] args){
        int[] arr = {
                1,2,2,4
        };
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(arr)));
    }

}
