package com.newcode.choose;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-10 9:26
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        final float i = 3.1f;
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0, 4);
        list.remove(1);
        System.out.println(list);
        System.out.println(Math.round(11.5));
    }
}
