package com.leetcode.offerTupo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-25 15:20
 * @Description 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        //先转为分钟，然后再排序，找出最小的
        List<Integer> nums = new ArrayList<>();
        for (String t: timePoints)
        {
            int h = Integer.parseInt(t.substring(0, 2));
            int m = Integer.parseInt(t.substring(3, 5));
            int x = h * 60 + m;
            nums.add(x);
            nums.add(x + 1440);
        }

        Collections.sort(nums);

        int n = nums.size();
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i ++)
        {
            int x = nums.get(i - 1);
            int y = nums.get(i);
            res = Math.min(res, y - x);
        }

        return res;

    }

    public static void main(String[] args) {
        List<String> times = new ArrayList<>();
        times.add("23:59");
        times.add("00:00");
        System.out.println(new FindMinDifference().findMinDifference(times));
    }
}
