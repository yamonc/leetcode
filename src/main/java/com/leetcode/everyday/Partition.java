package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-03-07 9:11
 * @Description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @Version 1.0
 */
public class Partition {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        f=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],true);
        }
        for (int i = n-1; i >=0; --i) {
            for (int j = i+1; j <n; ++j) {
                f[i][j]=(s.charAt(i)==s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int i) {
        if (i==n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j <n; ++j) {
            if (f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
            }
        }
    }

    public static void main(String[] args) {
        new Partition().partition("aaba");
    }
}
