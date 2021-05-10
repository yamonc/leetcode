package com.leetcode.stack.practice;

/**
 * @Author yamon
 * @Date 2021-05-03 10:15
 * @Description
 * @Version 1.0
 */
public class ArrayStack {

    private String[] items;
    private int count;
    private int n;

    /**
     * 初始化栈空间
     * @param n 输入的大小
     */
    public ArrayStack(int n){
        this.items= new String[n];
        this.n = n;
        this.count=0;
    }

    /**
     * 入栈操作
     * @param item 带入栈元素
     * @return 是否成功
     */
    public boolean push(String item){
        if (count==n){
            return false;
        }
        items[count]=item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     * @return 出栈元素
     */
    public String pop(){
        if (count==0){
            return null;
        }
        String item = items[count-1];
        --count;
        return item;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        final String pop = arrayStack.pop();
        System.out.println(pop);
    }
}
