package com.leetcode.offerTupo;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-08-23 14:44
 * @Description list存放数组元素，map中存放的是list元素的下标和对应下标上存储的元素,map{ val->idx}
 * @Version 1.0
 */
public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        //首先判断元素是否存在
        if (map.containsKey(val)){
            return false;
        }
        //将val作为key存到map中，value是list数组的长度，这就做到了总将元素添加到最后一个位置
        map.put(val, list.size());
        //list.add()两个参数：第一个参数表示
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //删除的话，在map中查找到删除元素的索引
        if (!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        //获取list的最后一个元素
        int last = list.get(list.size()-1);
        //将last元素设置到list的最后一个位置
        list.set(idx,last);
        //将last，idx设置到map中
        map.put(last, idx);
        //删除最后一个元素
        list.remove(list.size()-1);
        //删除map中的key
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {

    }
}
