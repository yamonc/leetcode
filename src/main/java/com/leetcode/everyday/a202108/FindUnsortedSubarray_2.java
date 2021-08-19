package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-03 14:39
 * @Description 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindUnsortedSubarray_2 {
    int MIN = -100005, MAX = 100005;

    /**
     * 线性扫描
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        //先特判
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int n = nums.length;

        int i = 0, j = n - 1;
        while (i < j && nums[i] <= nums[i + 1]) {
            i++;
        }
        while (i < j && nums[j] >= nums[j - 1]) {
            j--;
        }
        int l = i, r = j;
        int min = nums[i], max = nums[j];
        for (int u = l; u <= r; u++) {
            if (nums[u] < min) {
                while (i >= 0 && nums[i] > nums[u]) {
                    i--;
                }
                min = i >= 0 ? nums[i] : MIN;
            }
            if (nums[u] > max) {
                while (j < n && nums[j] < nums[u]) {
                    j++;
                }
                max = j < n ? nums[j] : MAX;
            }
        }
        return j == i ? 0 : (j - 1) - (i + 1) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        new FindUnsortedSubarray_2().findUnsortedSubarray(arr);
    }
}
