package com.leetcode.everyday;

/**
 * @Author yamon
 * @Date 2021-04-10 9:12
 * @Description
 * @Version 1.0
 */
public class IsUgly {

    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] factors={2,3,5};
        for (int factor:factors){
            while (n%factor==0){
                n/=factor;
            }
        }
        return n==1;
    }

    public static void main(String[] args) {
        new IsUgly().isUgly(8);
    }

}
