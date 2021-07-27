package com.leetcode.array;

import java.util.Map;
import java.util.TreeMap;

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
 * @Version 1.0 二叉搜索树
 */
public class FindKthLargest_heap {
    public int findKthLargest(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return -1;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(((o1, o2) -> o2-o1));
        int cnt = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            //取出map中最小的数字
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if(entry.getKey()<num){
                //将num放进去，然后删除最小的数字
                map.put(num, map.getOrDefault(num, 0)+1);
                if(entry.getValue()==1){
                    map.pollLastEntry();
                }else{
                    map.put(entry.getKey(), entry.getValue()-1);
                }
            }
        }
        //直接返回map的第一个值即可
        return map.isEmpty()?-1:map.lastKey();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(new FindKthLargest_heap().findKthLargest(arr, 2));
    }
}
