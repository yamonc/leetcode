package com.leetcode.everyday.a202108;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-08-24 14:38
 * @Description 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Queue<int[]> queue = new LinkedList<>();
        //构造图边集
        List<int[]>[] edge = new List[n];
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
            prices[i] = Integer.MAX_VALUE;
        }
        for (int[] flight : flights) {
            edge[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        prices[src] = 0;
        //bfs
        queue.add(new int[]{src, 0, prices[src]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[1] > k) {
                break;
            }
            for (int[] next : edge[poll[0]]) {
                if (prices[next[0]] > poll[2] + next[1]) {
                    prices[next[0]] = poll[2] + next[1];
                    queue.add(new int[]{next[0], poll[1] + 1, prices[next[0]]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1:prices[dst];
    }

    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 2, 500}
        };
        new FindCheapestPrice().findCheapestPrice(n, flights, src, dst, k);
    }
}
