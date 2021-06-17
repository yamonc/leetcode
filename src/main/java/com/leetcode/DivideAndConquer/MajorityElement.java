package com.leetcode.DivideAndConquer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-06-03 20:41
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int majorityNum = len/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])){
                //包含了+1
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        final Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer)>majorityNum){
                System.out.println(integer);
                return integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        new MajorityElement().majorityElement(arr);
    }
}
