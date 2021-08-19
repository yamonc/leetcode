package com.leetcode.compeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-05 16:14
 * @Description 求数组中比左边元素都大，同时比右边元素都小的元素，返回这些元素的索引
 * 思路：
 * 如果有这样的两个数组：
 * leftMax[i] 表示原数组[0,i)的最大值
 * rightMin[i] 表示原数组(i,n]的最小值
 * 内循环就可以通过leftMax[i]<num[i]&& nums[i]<rightMin[i]来判断。
 * 对于这两个数组，提前先算好，每个数组都能o(n)得到
 * leftMax和rightMin递推式：
 * leftMax[i] = max(leftMax[i-1], nums[i-1])
 * rightMin[i] = min(rightMin[i+1], nums[i+1])
 * @Version 1.0
 */
public class LeftMaxRightMin {
    public List<Integer> leftMaxRightMin(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int[] leftMax = new int[n];
        Arrays.fill(leftMax, Integer.MIN_VALUE);
        int[] rightMin = new int[n];
        Arrays.fill(rightMin, Integer.MAX_VALUE);
        //先计算左侧的最大值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }
        //计算右侧的最大值
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }
        //计算出最大下标和最小小标
        for (int i = 0; i < n; i++) {
            if(leftMax[i] <arr[i] && arr[i]<rightMin[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 9, 20, 12};
        System.out.println(new LeftMaxRightMin().leftMaxRightMin(arr));
    }
}
