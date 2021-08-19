package com.leetcode.everyday.a202108;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-08-09 14:49
 * @Description 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 * <p>
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class NthSuperUglyNumber {
    /**
     * 起初将最小的丑数放入队列中，每次从队列中取出最小值x，然后x所对应的x*primes[i]进行入队。最后重复上述入队。
     * 第n次出队即为答案
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        set.add(1L);
        while (n-- > 0) {
            long x = q.poll();
            if (n == 0) {
                return (int) x;
            }
            for (int k : primes) {
                if (!set.contains(k * x)) {
                    set.add(k * x);
                    q.add(k * x);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 13, 19};
        System.out.println(new NthSuperUglyNumber().nthSuperUglyNumber(12, arr));
    }
}
