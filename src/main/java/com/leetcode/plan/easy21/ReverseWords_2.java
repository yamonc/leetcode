package com.leetcode.plan.easy21;

/**
 * @Author yamon
 * @Date 2021-07-06 16:08
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReverseWords_2 {
    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i<length){
            int start = i;
            //找到第一块
            while (i<length && s.charAt(i)!=' '){
                i++;
            }
            //开始反转
            for(int p = start;p<i;p++){
                stringBuffer.append(s.charAt(start+i-1-p));
            }
            //判断是否加括号
            while (i < length && s.charAt(i) == ' ') {
                i++;
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ReverseWords_2().reverseWords("Let's take LeetCode contest"));
    }
}
