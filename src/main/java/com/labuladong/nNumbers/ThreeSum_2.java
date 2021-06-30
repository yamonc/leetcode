package com.labuladong.nNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-22 9:46
 * @Description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
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
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 双指针
 */
public class ThreeSum_2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //穷举three num中的第一个数
        for (int i = 0; i < n; i++) {
            List<List<Integer>> lists = twoSumTarget(nums, i + 1, 0 - nums[i]);
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
        int[] arr = {-1, 0, 1, 2, -1, -4};
//        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(new ThreeSum_2().threeSum(arr));
    }
}
