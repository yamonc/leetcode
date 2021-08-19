package com.leetcode.everyday.a202108;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-08-06 15:38
 * @Description 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 *
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：graph = [[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一种可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一种可能的路径为 [0,1,4,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ShortestPathLength {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        //初始化队列以及标记数组，存入起点

        //三个属性分别为idx ，mask， dist
        Queue<int[]> queue = new LinkedList<>();
        //节点编号以及当前状态
        boolean[][] vis = new boolean[n][1<<n];
        for (int i = 0;i<n;i++){
            //存入起点，其实距离，标记
            queue.offer(new int[]{i, 1<<i, 0});
            //起点标记已经访问过
            vis[i][1<<i] = true;
        }
        //开始搜索
        while (!queue.isEmpty()){
            //弹出队头
            int[] tuple = queue.poll();
            int idx = tuple[0], mask = tuple[1], dist = tuple[2];

            //找到答案，返回
            if(mask == (1<<n)-1){
                return dist;
            }
            //bfs扩展
            for(int x : graph[idx]){
                int next_mask = mask | (1<<x);
                if(!vis[x][next_mask]){
                    queue.offer(new int[]{x, next_mask, dist+1});
                    vis[x][next_mask] = true;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
