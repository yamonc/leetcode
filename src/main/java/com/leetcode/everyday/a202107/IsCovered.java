package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2021-07-23 14:04
 * @Description
 * @Version 1.0
 */
public class IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for(int i =left;i<=right;i++){
            boolean ok = false;
            for(int[] cur : ranges){
                int l = cur[0];
                int r = cur[1];
                if(l<=i && i<=r){
                    ok = true;
                    break;
                }
            }
            if(!ok){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr ={
                {37,49},
                {5,17},
                {8,32}
        };
        System.out.println(new IsCovered().isCovered(arr, 29, 49));
    }
}
