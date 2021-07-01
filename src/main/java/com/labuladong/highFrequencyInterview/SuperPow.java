package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-01 14:38
 * @Description 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        if(a==1){
            return 1;
        }
        int len = b.length;
        int sum = 0;
        int n = len;
        for(int i =0;i<len;i++,n--){
            sum+= (b[i]*Math.pow(10, n-1));
        }
        return (int) (Math.pow(a, sum)%1337);
    }

    public static void main(String[] args){
        int[] arr = {2,0,0};
        System.out.println(new SuperPow().superPow(2147483647, arr));
    }
}
