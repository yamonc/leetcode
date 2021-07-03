package com.labuladong.highFrequencyInterview;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-02 15:45
 * @Description 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,1]
 * 输出：2
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 异或
 */
public class MissingNumber_3 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        //先和新补的索引异或一下
        res ^= n;
        //和其他的元素、索引做异或
        for(int i =0; i< n;i++){
            res ^= i^nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr ={
                0,1,2,4
        };
        System.out.println(new MissingNumber_3().missingNumber(arr));
    }
}
