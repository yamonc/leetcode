package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-08 15:31
 * @Description 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/JFETK5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int up = 0;
        int ar = aChars.length - 1, br = bChars.length - 1;
        while (ar >= 0 || br >= 0) {
            int tempA = ar >= 0 ? aChars[ar--] - '0' : 0;
            int tempB = br >= 0 ? bChars[br--] - '0' : 0;
            int sum = tempA + tempB + up;
            up = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            ans.append(sum);
        }
        if (up == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        final String s = new AddBinary().addBinary("1010", "1011");
        System.out.println(s);
    }
}
