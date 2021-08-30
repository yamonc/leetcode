package com.test.bohaiBank;

import java.util.Scanner;

/**
 * @Author yamon
 * @Date 2021-08-30 10:54
 * @Description 分糖果 小明老师准备给同学们发放糖果，结果同学们提前发现了，全部拿走了，现在每个同学手上有若干糖果，小明希望每个同学的糖果都是相同的，因此需要从
 * 某些同学手里拿走一部分糖果，再分配给其他同学。要求是人人相等，尽可能多。需要最少从多少个同学那拿走糖果
 * @Version 1.0 渤海银行笔试题。
 */
public class Candy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = sc.nextInt();
        }
        int res = exchange(candy);
        System.out.println(res);
    }

    private static int exchange(int[] candy) {
        int all = 0;
        int n = candy.length;
        for (int j : candy) {
            all += j;
        }
        int target = all /n;
        int res = 0;
        for (int can : candy){
            if (can > target){
                res++;
            }
        }
        return res;
    }

}
