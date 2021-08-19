package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-31 15:03
 * @Description 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        //定义dp数组，dp[i][j]表示到达[i,j]的时候，最大获得的礼物数。
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i!=0 && j!=0){
                    //1. 考虑当前位置不在左边界和上边界，即i!=0 && j!=0,这时需要考虑左侧和上侧中间的一个最大值。
                    //比如测试用例中的5的位置，也就是grid[1][1]
                    dp[i][j] = grid[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
                }else if(i!=0 && j==0){
                    //2. 考虑当前位置靠近左边界，dp[i][j]只能从上面获得，即i!=0&&j==0,比如测试用例中的1 grid[1][0]
                    dp[i][j] = grid[i][j]+dp[i-1][j];
                }else if(i==0 && j!=0){
                    //3. 考虑当前位置靠近上边界，这时候dp[i][j]只能是从左侧动规过来，即i==0&&j!=0,比如测试用例中的 1grid[0][1]
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else {
                    //4。 考虑当前位置即靠近上边界，又靠近下边界，这时候dp[i][j]只能是起点，也是初试条件吧。也就是简化为dp[0][0] = grid[0][0]
                    dp[i][j] = grid[i][j];
                }
                //代码可以简化，这不过这样看的更简单，更方便。
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
