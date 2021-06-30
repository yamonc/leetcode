package com.leetcode.offer;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-22 10:51
 * @Description 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int temp = 1;
            for (int j = 0; j < a.length; j++) {
                if (i!=j){
                    temp*=a[j];
                }
            }
            res[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {
                1,2,3,4,5
        };
        System.out.println(Arrays.toString(new ConstructArr().constructArr(arr)));
    }
}
