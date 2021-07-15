package com.leetcode.everyday;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-03 9:08
 * @Description 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FrequencySort {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char aChar : chars) {
            if (hash.containsKey(aChar)) {
                hash.put(aChar, hash.getOrDefault(aChar, 0) + 1);
            } else {
                hash.put(aChar, 1);
            }
        }
        //按照value排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hash.entrySet());
        //通过Collections.sort(List,Comparactor) 排序
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            Integer i = entry.getValue();
            Character c = entry.getKey();
            for(int j = 0;j<i;j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort("Aabb"));
    }
}
