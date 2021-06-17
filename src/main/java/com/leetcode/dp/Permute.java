package com.leetcode.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-07 10:15
 * @Description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Permute {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(nums, trace);
        return res;
    }
    public void backtrace(int[] nums, LinkedList<Integer> trace){
        //触发结束条件
        if (trace.size()==nums.length){
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (trace.contains(nums[i])){
                continue;
            }
            //做选择
            trace.add(nums[i]);
            //进入下一层递归树中
            backtrace(nums, trace);
            //取消选择
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new Permute().permute(arr));
    }
}
