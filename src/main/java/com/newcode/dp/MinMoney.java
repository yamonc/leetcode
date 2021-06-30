package com.newcode.dp;

/**
 * @Author yamon
 * @Date 2021-06-25 14:42
 * @Description 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 * 【要求】
 * 时间复杂度O(n \times aim)O(n×aim)，空间复杂度On。
 * @Version 1.0
 */
public class MinMoney {
    /**
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        // write code here
        if (aim==0){
            return 0;
        }
        int[] memo = new int[aim+1];
        return dp(arr, aim, memo);
    }

    private int dp(int[] arr, int aim, int[] memo) {
        if (aim==0){
            return 0;
        }
        if (aim <0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        if (memo[aim]!=0){
            return memo[aim];
        }
        for (int coin : arr) {
            int res = dp(arr, aim-coin, memo);
            if (res>=0 && res < min){
                min = 1+res;
            }
        }
        min = min==Integer.MAX_VALUE?-1:min;
        memo[aim] = min;
        return memo[aim];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5};
        System.out.println(new MinMoney().minMoney(arr, 10));
    }
}
