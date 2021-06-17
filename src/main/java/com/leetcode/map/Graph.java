package com.leetcode.map;

import sun.awt.image.ImageWatched;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-05-24 20:30
 * @Description
 * @Version 1.0
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == 1) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size()!=0){
            int w = queue.poll();
            for (int i=0;i<adj[w].size();++i){
                int q = adj[w].get(i);
                if (!visited[q]){
                    prev[q] = w;
                    if (q==t){
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    private void print(int[] prev, int s, int t){
        if (prev[t]!=-1&&t!=s){
            print(prev,s,prev[t]);
        }
        System.out.println(t+" ");
    }
}
