package com.leetcode.array;

/**
 * @Author yamon
 * @Date 2021-07-27 16:18
 * @Description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 计数排序
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return -1;
        }
        //统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num : nums) {
            counter[num]++;
        }
        int n = nums.length-k+1;
        int[] res = new int[n];
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0 && idx < n) {
                res[idx++] = i;
            }
            if(idx == n){
                break;
            }
        }
        return res[res.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(new FindKthLargest().findKthLargest(arr, 4));
    }
}
