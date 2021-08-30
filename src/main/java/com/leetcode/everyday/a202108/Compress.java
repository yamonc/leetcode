package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-21 17:15
 * @Description 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * <p>
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 * 示例 3：
 * <p>
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Compress {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0,j=0;
        //i用来控制左边界，j用来记录新数组的长度，同时j也是右边界。
        while (i<n){
            //定义一个idx变量来控制i，刚开始表示左边界，随着相同字符的增加而增加。表示相同的字符有多少个，比如测试用力 abbcccc,如果第一次进入循环，则idx表示1.第二次idx=2
           int idx = i;
           while (idx<n && chars[idx] == chars[i]){
               idx++;
           }
           int cnt = idx-i; //记录相同字符的个数，idx表示旧的字符数组当前的位置，也就相当于右指针
           chars[j++] = chars[i]; //先记录相同字符，然后j++，表示指向下一个位置。比如 abbbcccc，那么第一次循环到这里的话，chars数组里面第0个位置应该是a。
           if (cnt>1){
               //如果有重复的， 更新参数j，表示新数组的当前位置，定义end只是为了赋值给j。
               int start = j, end = start;
               while (cnt!=0){
                   chars[end++] = (char) (cnt%10 +'0'); //将数字转换成为字符串并存到新数组中
                   cnt/=10; //如果是大于10的话，
               }
               //之所以需要反转是因为如果数字大于10的话，比如13，则可能会出现ab31,而不是ab13，所以需要反转
               reverse(chars, start, end-1);
               j = end;//更新当前数组的位置。
           }
           //更新左边界
           i = idx;
        }
        return j;
    }
    void reverse(char[] cs, int start, int end){
        while (start<end){
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        new Compress().compress(a);
    }
}
