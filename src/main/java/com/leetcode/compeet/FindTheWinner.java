package com.leetcode.compeet;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-04-11 14:48
 * @Description
 * @Version 1.0
 */
public class FindTheWinner {
    public int findTheWinner(int n, int k){
        List<Integer> list = new ArrayList<>(n);
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int idx = 0;
        while (n>1){
            idx= (idx+k-1)%n;
            list.remove(idx);
            n--;
        }
        return list.get(0)+1;
    }
}
