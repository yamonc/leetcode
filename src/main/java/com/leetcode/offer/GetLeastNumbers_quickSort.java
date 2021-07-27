package com.leetcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-27 10:39
 * @Description输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
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
 * @Version 1.0 快排
 */
public class GetLeastNumbers_quickSort {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //最后一个参数表示我们要找的是下标为k-1的数
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }


    private int[] quickSort(int[] nums, int lo, int hi, int k) {
        //每次快排切分1次，找到排序后下标为j的元素，如果j恰好==k 返回j以及j左侧的所有数
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        //否则根据下标j与k的大小关系来决定继续切分左端还是右端
        return j > k ? quickSort(nums, lo, j - 1, k) : quickSort(nums, j + 1, hi, k);
    }

    //快排切分，返回下标j，使得比nums【j】小的数都在j的左边
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) {
                ;
            }
            while (--j >= lo && nums[j] > v) {
                ;
            }
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new GetLeastNumbers_quickSort().getLeastNumbers(arr, 4)));
    }
}
