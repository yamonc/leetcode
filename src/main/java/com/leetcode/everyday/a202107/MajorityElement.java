package com.leetcode.everyday.a202107;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-09 15:49
 * @Description 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //使用hash表完成，一旦元素超过hash表的一半，则说明找到了
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)>nums.length/2){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        System.out.println(new MajorityElement().majorityElement(arr));
    }
}
