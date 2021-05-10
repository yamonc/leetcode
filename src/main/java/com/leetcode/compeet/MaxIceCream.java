package com.leetcode.compeet;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-04-18 15:26
 * @Description 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        int length = costs.length;
        // 先排序
        Arrays.sort(costs);
        if (coins < costs[0]) {
            return 0;
        }
        int count = 0;
        for (int cost : costs) {
            if (coins > 0 && coins>=cost) {
                coins = coins - cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1};
        System.out.println(new MaxIceCream().maxIceCream(arr, 7));
    }
}
