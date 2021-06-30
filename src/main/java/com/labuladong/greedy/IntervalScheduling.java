package com.labuladong.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author yamon
 * @Date 2021-06-28 10:13
 * @Description 计算有几个互不相交的区间 eg:[
 * [1,3],
 * [2,4],
 * [3,6]
 * ],证明有两个，[1,3],[3,6]
 * @Version 1.0
 */
public class IntervalScheduling {
    public int intervalScheduling(int[][] ins) {
        //特判
        if (ins.length == 0) {
            return 0;
        }
        //按照右侧升序排序
        Arrays.sort(ins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int x_end = ins[0][1];
        for (int[] in : ins) {
            int start = in[0];
            if (start >= x_end) {
                count++;
                x_end = in[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-2147483646,-2147483645},{2147483646,2147483647}
        };
        System.out.println(new IntervalScheduling().intervalScheduling(arr));
    }
}
