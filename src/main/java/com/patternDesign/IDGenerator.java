package com.patternDesign;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author yamon
 * @Date 2021-06-19 9:32
 * @Description 饿汉式
 * @Version 1.0
 */
public class IDGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final IDGenerator instance = new IDGenerator();
    private IDGenerator(){

    }
    public static IDGenerator getInstance(){
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
