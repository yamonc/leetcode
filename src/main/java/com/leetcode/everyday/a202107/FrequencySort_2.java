package com.leetcode.everyday.a202107;

import java.util.HashMap;
import java.util.Map;

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
 * @Version 1.0 桶排序
 */
public class FrequencySort_2 {
    public String frequencySort(String s) {


        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int length = s.length();
        //把s的所有字符添加到hashMap中，顺便记录下最大的频率值
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        //创建桶，准备排序
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        //初始化桶完毕
        //取出键值对，map中的value存储的是频率，根据频率的高低添加到桶内
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        //按照桶内的最大频率遍历输出
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for(int j = 0;j<size;j++){
                for(int k = 0;k<i;k++){
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FrequencySort_2().frequencySort("Aabb"));
    }
}
