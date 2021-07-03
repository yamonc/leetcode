package com.labuladong.highFrequencyInterview;

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
 * @Version 1.0 等差数列
 */
public class MissingNumber_4 {
    public int missingNumber(int[] nums) {
        //等差数列公式：（首相+尾项）*n然后除以2
        int n = nums.length;
        int expect = (0+n)*(n+1)/2;
        int sum = 0;
        for(int x :nums){
            sum+=x;
        }
        return expect-sum;

    }

    public static void main(String[] args) {
        int[] arr ={
                0,1,2,4
        };
        System.out.println(new MissingNumber_4().missingNumber(arr));
    }
}
