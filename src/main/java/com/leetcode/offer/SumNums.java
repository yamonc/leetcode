package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-20 10:47
 * @Description 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SumNums {
    public int sumNums(int n) {
        if(n==1){
            return 1;
        }
        return n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new SumNums().sumNums(3));
    }
}
