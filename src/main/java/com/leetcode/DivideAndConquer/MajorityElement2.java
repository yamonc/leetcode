package com.leetcode.DivideAndConquer;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-06-03 20:41
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 2.0  动态规划
 */
public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    /**
     * 按照范围跟num对比，相同的话，++
     *
     * @param nums
     * @param num
     * @param l
     * @param r
     * @return
     */
    public int countInRange(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        //左半部分和右半部分开始递归
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        //如果两半部分都一样的话，返回任意一个就行
        if (left == right) {
            return left;
        }
        //如果两部分不相同，计算每一个元素，并返回最大者
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(new MajorityElement2().majorityElement(arr));
    }
}
