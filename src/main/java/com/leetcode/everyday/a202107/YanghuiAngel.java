package com.leetcode.everyday.a202107;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2020-12-06 18:26
 * @Description 杨辉三角
 * @Version 1.0
 */
public class YanghuiAngel {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j==0 || j == i){
                    row.add(1);
                } else{
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        final List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
}
