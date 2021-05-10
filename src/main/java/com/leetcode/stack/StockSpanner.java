package com.leetcode.stack;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-04-21 20:38
 * @Description [100, 80, 60, 70, 60, 75, 85]
 *              [1, 1, 1, 2, 1, 4, 6]
 * @Version 1.0
 */
public class StockSpanner {

    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();

    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            w+= weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        final StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(85);
    }
}
