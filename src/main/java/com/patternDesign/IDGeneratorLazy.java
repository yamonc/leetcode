package com.patternDesign;


import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author yamon
 * @Date 2021-06-19 9:32
 * @Description 饿汉式
 * @Version 1.0
 */
public class IDGeneratorLazy {
    private AtomicLong id = new AtomicLong(0);
    private static IDGeneratorLazy instance;
    private IDGeneratorLazy(){

    }
    public static synchronized IDGeneratorLazy getInstance(){
        if (instance==null){
            instance = new IDGeneratorLazy();
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
