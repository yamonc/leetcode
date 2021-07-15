package com.test;

import com.labuladong.highFrequencyInterview.SuperPow;

/**
 * @Author yamon
 * @Date 2021-07-06 9:27
 * @Description
 * @Version 1.0
 */
class Supper {
    public int get(){
        System.out.println("Super");
        return 5;
    }
}
class Sub{
    public int get(){
        System.out.println("Sub");
        return new Integer(5);
    }

    public static void main(String[] args) {
        new Supper().get();
        new Sub().get();
    }
}
