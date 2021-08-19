package com.leetcode.everyday.a202108;

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
public class TitleToNumber_off {

    public int titleToNumber(String columnTitle) {
        char[] cs = columnTitle.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
           ans = ans *26+(cs[i]-'A'+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber_off().titleToNumber("ZY"));
    }
}
