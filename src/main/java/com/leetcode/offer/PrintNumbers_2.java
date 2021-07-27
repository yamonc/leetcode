package com.leetcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-27 9:22
 * @Description 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 大数打印
 */
public class PrintNumbers_2 {
    int[] res;
    int count = 0,nine = 0,start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        //数字字符串集合
        res = new int[(int)Math.pow(10, n) - 1];
        //定义长度为n的字符列表
        num = new char[n];
        //定义左边界
        start = n-1;
        //全排列
        dfs(0);
        //删除最后多余的逗号
        return res;
    }

    public void dfs(int x){
        if(x==n){
            //终止条件，已经固定完所有的位置
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")){
                res[count++]=Integer.parseInt(s);
            }
            if(n-start==nine){
                start--;
            }
            return;
        }
        for(char i : loop){
            if(i=='9'){
                nine++;
            }
            //遍历0-9
            num[x] = i;
            dfs(x+1);
        }
        nine--;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrintNumbers_2().printNumbers(3)));
    }
}
