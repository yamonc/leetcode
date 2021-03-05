package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-03-04 16:42
 * @Description 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。
 * <p>
 * 题目数据保证答案是唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j <target.length; i++) {
            //记录缺少的数字
            if (i != target[j]) {
                ans.add("Push");
                ans.add("Pop");
            } else {
                ans.add("Push");
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temp = {2, 3,4};
        final List<String> strings = new BuildArray().buildArray(temp, 4);
        for (String string : strings) {
            System.out.print(string);
        }
    }
}
