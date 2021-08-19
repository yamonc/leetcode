package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-12 15:23
 * @Description 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 * <p>
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aseY1I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            for (char c : words[i].toCharArray()) {
                ints[i] |= (1 << (c - 97));
            }
        }
        int res = 0;
        for (int i = 0; i < length - 1; i++) {
            int pre1 = ints[i];
            for (int j = i + 1; j < length; j++) {
                int pre2 = ints[j];
                if ((pre1 & pre2) == 0) {
                    int te = words[i].length() * words[j].length();
                    res = Math.max(res, te);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new MaxProduct().maxProduct(words));
    }
}
