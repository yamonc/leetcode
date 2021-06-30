package com.labuladong;

/**
 * @Author yamon
 * @Date 2021-06-30 9:24
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //构造前缀和
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i = 0;i<n;i++){
            sum[i+1] = nums[i]+sum[i];
        }

        int ans = 0;
        //穷举所有子数组
        for(int i =1;i<=n;i++){
            for(int j = 0;j<i;j++){
                if(sum[i] - sum[j] == k){
                    ans ++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {
                1,2,3,4,5
        };
        System.out.println(new SubarraySum().subarraySum(arr, 7));
    }
}
