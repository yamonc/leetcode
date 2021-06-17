package com.newcode.offer;

/**
 * @Author yamon
 * @Date 2021-06-07 16:17
 * @Description
 * @Version 1.0
 */
public class Sum_Solution {
    private int sum=0;
    public int Sum_Solution(int n) {
        backtrace(n);
        return sum;
    }
    public void backtrace(int n){
        if(n==0){
            return ;
        }
        sum+=n;
        backtrace(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Sum_Solution().Sum_Solution(5));
    }
}
