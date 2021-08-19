package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-31 15:43
 * @Description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i =0, j = nums.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if(nums[m]==m){
                i=m+1;
            }else{
                j = m-1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(new MissingNumber().missingNumber(arr));
    }
}
