package com.leetcode.everyday.a202108;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-04 15:56
 * @Description 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 暴力法
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i <nums.length; i++) {
            for (int j = i-1; j >=0; j--) {
                for (int k = j-1; k >=0; k--) {
                    if (nums[i]<nums[j]+nums[k]){
                        ans++;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        System.out.println(new TriangleNumber().triangleNumber(arr));
    }
}
