package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2020-11-14 9:00
 * @Description
 * 1122.
 * 给你两个数组，arr1 和arr2，
 *
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *

 * @Version 1.0
 */
public class ArrayAbsolutelySorted {
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        int upper = 0;
        for (int x : arr1){
            upper = Math.max(upper,x);
        }
        int[] frequency = new int[upper+1];
        for (int x : arr1){
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x :arr2){
            for (int i=0;i<frequency[x];++i){
                ans[index++]=x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x<=upper;++x){
            for (int i = 0;i<frequency[x];++i){
                ans[index++] =x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        final int[] ints = relativeSortArray(arr1, arr2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(i);
        }

    }
}
