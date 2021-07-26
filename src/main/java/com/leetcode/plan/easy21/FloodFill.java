package com.leetcode.plan.easy21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-07-26 20:23
 * @Description
 * @Version 1.0
 */
public class FloodFill {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if(mx >=0&&mx<n && my>=0&&my<m && image[mx][my] == currColor){
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},{1,1,0},{1,0,1}
        };
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, 1, 1, 2)));
    }
}
