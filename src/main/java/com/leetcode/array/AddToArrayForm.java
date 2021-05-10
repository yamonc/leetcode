package com.leetcode.array;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-04-11 9:14
 * @Description
 * @Version 1.0
 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int n=num.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = n-1;i>=0;i--){
            int sum = num[i]+k%10;
            k/=10;
            if (sum>=10){
                k++;
                sum-=10;
            }
            ans.add(sum);
        }
        for(;k>0;k/=10){
            ans.add(k%10);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {2,1,5};
        int k=806;
        System.out.println(new AddToArrayForm().addToArrayForm(num, k));
    }
}
