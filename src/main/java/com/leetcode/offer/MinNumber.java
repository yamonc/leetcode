package com.leetcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-14 17:15
 * @Description 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x,y)->(x+y).compareTo(y+x));

        StringBuilder stringBuilder = new StringBuilder();
        for(String s:strs){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
