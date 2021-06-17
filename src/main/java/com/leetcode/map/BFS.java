package com.leetcode.map;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-05-24 20:38
 * @Description
 * @Version 1.0
 */
public class BFS {
    public static boolean[] visit = new boolean[6];
    static  int[][] maze = {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0}
    };
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            if (visit[i]==true){
                continue;
            }else {
                BFS(i);
            }
            
        }
    }

    private static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visit[s] = true;
        while (!queue.isEmpty()){
            int w = queue.poll();
            System.out.println(w);
            for (int i = 1; i <=5; i++) {
                if (!visit[i] && maze[w-1][i-1] == 1){
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
