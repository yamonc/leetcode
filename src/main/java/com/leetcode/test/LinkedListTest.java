package com.leetcode.test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author yamon
 * @Date 2021-05-27 8:54
 * @Description
 * @Version 1.0
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");

        List<String> b = new LinkedList<>();
        b.add("ddd");
        b.add("eee");
        b.add("fff");
        b.add("ggg");

        ListIterator<String> aIter = a.listIterator();
        ListIterator<String> bIter = b.listIterator();
        while (bIter.hasNext()){
            if (aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);

        bIter = (ListIterator<String>) b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
