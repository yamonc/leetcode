package com.leetcode.everyday;

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
public class MajorityElement_2 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num:nums){
            if (count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        //遍历数组，查找candidate的值出现的次数是否大于nums的数量
        int ansCount = 0;
        for(int num:nums){
            if (num==candidate){
                ansCount++;
            }
        }
        if(ansCount*2>nums.length){
            return candidate;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9,5,9,5,5,5};
        System.out.println(new MajorityElement_2().majorityElement(arr));
    }
}
