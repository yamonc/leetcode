package com.patternDesign;


import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author yamon
 * @Date 2021-06-19 9:32
 * @Description 饿汉式
 * @Version 1.0
 */
public class IDGeneratorLazyDouble {
    private AtomicLong id = new AtomicLong(0);
    private static IDGeneratorLazyDouble instance;
    private IDGeneratorLazyDouble(){

    }
    public static  IDGeneratorLazyDouble getInstance(){
        if (instance==null){
            synchronized (IDGeneratorLazyDouble.class){
                if (instance==null){
                    instance = new IDGeneratorLazyDouble();
                }
            }
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
