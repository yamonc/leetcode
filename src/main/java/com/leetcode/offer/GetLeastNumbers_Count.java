package com.leetcode.offer;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author yamon
 * @Date 2021-07-27 10:39
 * @Description 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 计数排序
 */
public class GetLeastNumbers_Count {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        //根据counter数组从头找出k个数返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new GetLeastNumbers_Count().getLeastNumbers(arr, 4)));
    }
}
