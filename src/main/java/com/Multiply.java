package com;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-30 10:36
 * @Description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] res = new int[m+n];
        Arrays.fill(res, 0);
        //从个位开始逐位相乘
        for(int i = m-1; i>=0;i--){
            for(int j = n-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                //乘积在res对应的索引位
                int p1 = i+j;
                int p2 = i+j+1;
                //叠加到res上
                int sum = mul+res[p2];
                res[p2] = sum %10;
                res[p1] += sum/10;
            }
        }
        int i = 0;
        while(i < res.length && res[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(;i<res.length;i++){
            sb.append(res[i]);
        }
        return res.length==0?"0":sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Multiply().multiply("",""));
    }

}
