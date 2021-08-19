package com.leetcode.offerTupo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-12 16:11
 * @Description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = twoSum(nums, i+1, -nums[i]);
            if (!list.isEmpty()){
                list.add(nums[i]);
                ans.add(list);
            }
            while (i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ans;
    }

    public List<Integer> twoSum(int[] numbers, int left, int target) {
        int right = numbers.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans.add(numbers[left]);
                ans.add(numbers[right]);
                return ans;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0,1,2,-1,-4};
        new ThreeSum().threeSum(arr);
    }
}
