package com.leetcode.string.algorithm;

/**
 * @Author yamon
 * @Date 2021-05-27 21:08
 * @Description
 * @Version 1.0
 */
public class BM {
    private static final int SIZE = 256;
    private void generateBM(char[] b,int m, int[] bc){
        for (int i = 0; i < SIZE; i++) {
            //初始化bc
            bc[i]=-1;
        }
        for (int i =0;i<m;i++){
            int ascii = b[i];
            bc[ascii] = i;
        }
    }
    public int bm(char[] a, int n, char[] b, int m){
        //记录模式串中的每个字符最后出现的位置
        int[] bc = new int[SIZE];
        //构建坏字符hash表
        generateBM(b,m,bc);
        return 0;
    }




    public static void main(String[] args) {
        String a = "abda";
        int[] b = new int[256];
        new BM().generateBM(a.toCharArray(),a.length(),b);
    }
}
