package com.leetcode;

/**
 * @Author yamon
 * @Date 2021-06-12 9:08
 * @Description
 * @Version 1.0
 */
public class TestBaseAndSon {
    public static void main(String[] args) {
        Base base = new Son();
        Son son = (Son) base;
        base.method();
        son.methodB();
    }
}
