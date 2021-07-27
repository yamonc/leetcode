package com.leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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
 * @Version 1.0 大顶堆
 */
public class GetLeastNumbers_Heap {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //整体思路：保持堆的大小为K，然后遍历数组中的数字，遍历的时候需要判断：
        // 1. 如果当前堆的大小小于K，将当前数字放入堆中。
        // 2. 如果当前堆的大小不小于K，判断当前数组的数字与堆中堆顶元素比较大小，如果数字比堆顶大，则pass
        //3. 如果当前数字与堆中元素比较大小，数组比堆顶元素小，先poll堆顶，然后将数字放入堆中。
        //默认是小根对，实现大根对需要重写比较器
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if(pq.size() < k){
                pq.offer(num);
            }else if(num<pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        //返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num : pq){
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new GetLeastNumbers_Heap().getLeastNumbers(arr, 4)));
    }
}
