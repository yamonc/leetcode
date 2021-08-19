package com.leetcode.everyday.a202108;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-07-30 21:05
 * @Description 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <p>
 *  
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 示例 4:
 * <p>
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class TitleToNumber {
    Map<Character, Integer> map = new HashMap<>();

    public int titleToNumber(String columnTitle) {
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);
        if (columnTitle.length() == 0) {
            return 0;
        }
        char[] columnTitles = columnTitle.toCharArray();
        int ans = 0;
        for(int i = 0;i<columnTitles.length;i++){
            ans +=(Math.pow(26, columnTitles.length-i-1)*map.get(columnTitles[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("A"));
    }
}
