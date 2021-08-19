package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-08 14:44
 * @Description 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * <p>
 * 输入：a = 7, b = -3
 * 输出：0
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * <p>
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：a = 1, b = 1
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xoh6Oh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 *
 */
public class Divide {
    /**
     * 不用除法除
     * 整体思路：
     * 除法的本质就是减法。在计算的时候将正数转为负数计算。
     * 设置一个变量，记录正数的个数
     *
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        //特殊处理-2^31/ -1 = 2^31 溢出
        if(a==0x80000000 && b == -1){
            return 0x7FFFFFFF;
        }
        //假设都是正数个数为2
        int negetive = 2;
        if (a>0){
            negetive--;
            a = -a;
        }
        if (b>0){
            negetive--;
            b = -b;
        }
        //计算两个负数相处
        int ans = 0;
        while (a<=b){
            //统计减数
            int value = b;
            //统计商
            int quotient = 1;
            while(value > 0xc0000000 && value + value >= a){//value > 0xc0000000 防止value*2溢出
                quotient += quotient;//如果可以用乘法 quotient*=2
                value += value;//如果可以用乘法 value*=2
            }

            a-=value;
            ans+= value;
        }
        return negetive==1?-ans:ans;

    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(15, -2));
    }
}
