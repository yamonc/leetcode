package com.test.guanglianda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author yamon
 * @Date 2021-08-18 18:57
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[][] arr = {
                {-3,1,1},
                {1,2,2},
                {4,2,1}
        };
        System.out.println(new Test().cellCount(4, arr));
    }

    public int cellCount(int b, int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int time =0;
        int low =0;
        int height = 0;
        for (int[] a : arr) {
            int x = a[0];
            int y = a[1];
            int r = a[2];
            low =Math.min(low, y-r);
            height = Math.max(height, y+r);
            if (height-low<b){
                time++;
                //更新low和height
            }else {
                break;
            }
        }
        return time;
    }
}

