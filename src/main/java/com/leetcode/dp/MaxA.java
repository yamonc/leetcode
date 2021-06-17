package com.leetcode.dp;

/**
 * @Author yamon
 * @Date 2021-06-10 16:27
 * @Description 假设你有一个特殊的键盘包含一下四个键，A：在屏幕上打印A， ctrl+A：选中整个屏幕；ctrl+C：复制选中区域到缓冲区
 * ctrl+V：粘贴到屏幕上。现在你有N次机会，请问屏幕上最多可以显示多少A呢
 * eg： N=3  output：3 AAA
 *  N = 7 output：9 AAActrl+A,ctrl+C,ctrl+V,Ctrl+V
 * @Version 1.0
 */
public class MaxA {
    private int a_num=0;
    private int copy=0;
    public int maxA(int N){
        //状态n，a_num， copy
        return dp(N,a_num, copy);
    }

    public int dp(int N, int a_num, int copy){
        if (N<0){
            return a_num;
        }
        //集中选择全试一遍，选择最大的结果
        return maxInThree(dp(N-1, a_num+1, copy), dp(N-1, a_num+copy, copy),
                dp(N-2, a_num, a_num));
    }
    public int maxInThree(int a, int b, int c){
        int temp = Math.max(a,b);
        return Math.max(temp, c);
    }

    public static void main(String[] args) {
        System.out.println(new MaxA().maxA(3));
    }
}
