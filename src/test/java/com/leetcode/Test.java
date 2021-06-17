package com.leetcode;

/**
 * @Author yamon
 * @Date 2021-06-12 8:59
 * @Description
 * @Version 1.0
 */
public class Test {
    static int x=10;
    static {x+=5;}
    public static void main(String[] args) //4
    {
        System.out.println("x="+x);
    }
    static{x/=3;};
}
