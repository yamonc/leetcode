package com.test;

/**
 * @Author yamon
 * @Date 2021-08-01 19:35
 * @Description
 * @Version 1.0
 */
public class IsThree {
    public boolean isThree(int n) {
        if (n==0){
            return false;
        }
        int ans = 2;
        int k = n;
        while (n!=1){
            if(n!=k){
                if (k%n==0){
                    ans ++;
                }
            }
            n--;
        }
        return ans==3;
    }

    public static void main(String[] args) {
        System.out.println(new IsThree().isThree(12));
    }
}
