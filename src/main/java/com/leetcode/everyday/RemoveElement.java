package com.leetcode.everyday;

/**
 * @Author yamon
 * @Date 2021-04-19 8:33
 * @Description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right=0;right<n;right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        new RemoveElement().removeElement(arr,3);
    }
}
