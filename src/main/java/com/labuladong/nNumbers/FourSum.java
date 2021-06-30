package com.labuladong.nNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-22 10:33
 * @Description 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> lists = threeSum(nums,i+1, target-nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                res.add(list);
            }
            while ((i<n-1&&nums[i]==nums[i+1])){
                i++;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums,int start, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //穷举three num中的第一个数
        for (int i = start; i < n; i++) {
            List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - nums[i]);
            //如果存在满足条件的二元组，再加上nums[i] 即为答案
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                res.add(list);
            }
            //跳过第一个数字重复的情况，否则会出现重复结果
            while (i<n-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return res;
    }
    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
//        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(new FourSum().fourSum(arr, 0));
    }
}
