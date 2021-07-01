package com.labuladong.highFrequencyInterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-07-01 10:18
 * @Description 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int m = 2,n=3;
        StringBuilder start = new StringBuilder();
        String target = "123450";
        //将2*3转换成为字符串
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                start.append(board[i][j]);
            }
        }
        //记录一维字符串的相邻索引
        int[][] neighbor = {
                {1,3},
                {0,4,2},
                {1,5},
                {0,4},
                {3,1,5},
                {4,2}
        };
        //BFS开始
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start.toString());
        visited.add(start.toString());

        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            //向四周扩散
            for(int i=0;i<sz;i++){
                String cur = q.poll();
                //判断是否到达目标局面
                if(target.equals(cur)){
                    return step;
                }
                //否则的话，找到数字0，开始移动
                int idx = 0;
                for(;cur.charAt(idx)!='0';idx++){
                    //将数字0和相邻的数字交换位置
                    for(int adj : neighbor[idx]){
                        String new_board = cur;
                        swap(new_board.toCharArray(),adj, idx);
                        //防止走回头路
                        if(!visited.contains(new_board)){
                            q.offer(new_board);
                            visited.add(new_board);
                        }
                    }
                }
            }
            step++;
        }

        return -1;

    }
    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
