package com.newcode.offer;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-06-11 14:56
 * @Description 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 * 返回值描述：
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Version 1.0
 */
public class NoRepeatString {
    private Map<Character, Integer> map = new HashMap<>();
    private Deque<Character> deque = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        //首先先判断存在否？
        if (!map.containsKey(ch)){
            map.put(ch, 1);
            deque.addLast(ch);
        }else{
            //如果已经存在了，更新次数
            map.put(ch,map.get(ch)+1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //判断队列的元素
        while (!deque.isEmpty()){
            if (map.get(deque.getFirst())==1){
                //如果等于1的话，证明是第一个元素
                return deque.getFirst();
            }else{
                //不是的话，需要弹出
                deque.removeFirst();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        final NoRepeatString noRepeatString = new NoRepeatString();
        noRepeatString.Insert('g');
        System.out.println(noRepeatString.FirstAppearingOnce());
        noRepeatString.Insert('o');
        System.out.println(noRepeatString.FirstAppearingOnce());
        noRepeatString.Insert('o');
        System.out.println(noRepeatString.FirstAppearingOnce());
        noRepeatString.Insert('g');
        System.out.println(noRepeatString.FirstAppearingOnce());
        noRepeatString.Insert('l');
        System.out.println(noRepeatString.FirstAppearingOnce());
        noRepeatString.Insert('e');
        System.out.println(noRepeatString.FirstAppearingOnce());

    }
}
