package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-01 15:45
 * @Description 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            //.防止溢出
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= h;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        System.out.println(new MinEatingSpeed().minEatingSpeed(arr, 8));
    }
}
