package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-07-28 14:57
 * @Description
 * @Version 1.0
 */
public class MajorityElement_mogen {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            count += (num==candidate)?1:-1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MajorityElement_mogen().majorityElement(arr));
    }
}
