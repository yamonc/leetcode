package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-21 19:47
 * @Description
 * @Version 1.0
 */
public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new ReadBinaryWatch().readBinaryWatch(1);
    }

}
