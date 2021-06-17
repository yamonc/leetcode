package com.leetcode.string;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-06-11 15:26
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 队列里面直接存
 * @Version 1.0
 */
public class FirstUniqChar {
    private HashMap<Character, Integer> map = new HashMap<>();
    private Deque<Character> deque=new LinkedList<>();
    public int firstUniqChar(String s) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //将所有的字符放到map中，如果遇到重复的，只放第一次的，key为char，value为下标
            if (!map.containsKey(chars[i])){
                //没有重复的，存
                map.put(chars[i], i);
                //同时存到队列中
                deque.addLast(chars[i]);
            }else{
                //遇到重复的，
                deque.removeFirstOccurrence(chars[i]);
            }
        }
        final Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (deque.peekFirst()==null){
                return -1;
            }
            if (entry.getKey().equals(deque.getFirst())){
                return entry.getValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("aabb"));
    }
}
