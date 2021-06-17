package com.newcode.offer;

/**
 * @Author yamon
 * @Date 2021-06-11 10:13
 * @Description 描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入：
 * "123.45e+6"
 * 返回值：
 * true
 * 示例2
 * 输入：
 * "1.2.3"
 * 返回值：
 * false
 * @Version 1.0
 */
public class IsNumeric {
    public boolean isNumeric (String str) {
        // write code here
        if (str.length()==0){
            return false;
        }
        boolean isNum=false;
        boolean isDot=false;
        boolean ise_or_E=false;
        char[] chars = str.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='0' && chars[i] <= '9'){
                //判断当前字符是否为0-9的数位
                isNum=true;
            }else if (chars[i]=='.'){
                //遇到小数点
                if (isDot || ise_or_E){
                    //小数点之前可以没有整数，但不能重复出现小数点或者出现eE
                    return false;
                }
                //标记遇到了小数点
                isDot=true;
            }else if (chars[i]=='e' || chars[i] == 'E'){
                //遇到了e或者E
                if (!isNum || ise_or_E){
                    return false;
                }
                //标记遇到了E或者e
                ise_or_E=true;
                //重置isNum 因为e或者E之后必须接上整数，防止出现123e或者123E+的非法情况
                isNum=false;
            }else if (chars[i] =='-'|| chars[i]=='+'){
                if (i!=0 && chars[i-1]!= 'e' && chars[i-1]!='E'){
                    //正负号只可能出现在第一个位置或者出现在e或者E的后面一个位置
                    return false;
                }
            }else{
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        new IsNumeric().isNumeric("-1E-16");
    }
}
