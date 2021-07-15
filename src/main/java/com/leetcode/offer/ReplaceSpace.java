package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-05 16:20
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuffer =  new StringBuilder();
        for (char aChar : chars) {
            if (aChar!=' '){
                stringBuffer.append(aChar);
            }else{
                stringBuffer.append("%20");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace("We are happy"));
    }
}
