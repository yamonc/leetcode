package com.labuladong.highFrequencyInterview;

import java.util.LinkedList;
import java.util.List;

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
public class SuperPow_2 {
    int base = 1337;
    public int superPow(int a, int[] b) {
        List<Integer> list = new LinkedList<>();
        for(int bb : b){
            list.add(bb);
        }
        return sup(a, list);
    }
    public int sup(int a, List<Integer> list){
        //递归的base case
        if(list.isEmpty()){
            return 1;
        }
        //取出最后一个数
        int last = list.get(list.size()-1);
        //删除最后一个数
        list.remove(list.size()-1);

        int part1 = myPow(a, last);
        int part2 = myPow(sup(a, list), 10);
        return part1*part2%base;
    }
    //计算a的k次方结果
    int myPow(int a, int k){
        if(k==0){
            return 1;
        }
        a%=base;
        if(k%2==1){
            //奇数
            return (a * myPow(a, k-1)) %base;
        }else{
            //k偶数
            int sub = myPow(a, k/2);
            return (sub*sub) %base;
        }
    }

    public static void main(String[] args){
        int[] arr = {2,0,0};
        System.out.println(new SuperPow_2().superPow(2147483647, arr));
    }
}
