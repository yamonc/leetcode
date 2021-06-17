package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-07 10:39
 * @Description n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SolveNQueens {
    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] bo : board) {
            Arrays.fill(bo, '.');
        }
        backtrace(n,board, 0);
        return res;
    }
    public List<String> Array2List(char[][] board){
        List<String> list = new ArrayList<>();
        for (char[] c : board){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    /**
     * 路径：board中小于row的那些行已经成功放置皇后
     * 选择列表：第row行所有列都是可以放置皇后的选择
     * 结束条件：row超过board的最后一行
     *  @param board
     * @param row
     */
    public void backtrace(int n,char[][] board, int row) {
        //触发条件
        if (row == board.length) {
            res.add(Array2List(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if (!isValid(board, row, col,n)) {
                continue;
            }
            //做选择
            board[row][col] = 'Q';
            //下一行
            backtrace(n, board, row + 1);
            //撤销
            board[row][col] = '.';
        }

    }

    public boolean isValid(char[][] board, int row, int col,int n) {
        //检查列是否有冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(8);
    }

}
