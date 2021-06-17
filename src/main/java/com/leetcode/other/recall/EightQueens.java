package com.leetcode.other.recall;

import java.sql.PreparedStatement;

/**
 * @Author yamon
 * @Date 2021-06-05 10:10
 * @Description 八皇后问题：有一个8x8的棋盘，希望往里放8个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 * @Version 1.0
 */
public class EightQueens {
    private final int[] result = new int[8];

    public void cal8Queens(int row) {
        //调用方式 cal8Queens(0)
        if (row == 8) {
            //8个棋子都摆好了，打印结果
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            //每一行都有8中方法
            if (isOk(row, column)) {
                //有些方法不满足情况
                result[row] = column;
                //下一行
                cal8Queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        //判断row行column列放置是否合适
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row-1; i >= 0; --i) {
            //逐行向上检查
            if (result[i] == column){
                //检查第i行的column列有棋子吗？
                return false;
            }
            if (leftUp>0){
                //考察左上角元素，第i行leftUp列有棋子吗
                if (result[i] == leftUp){
                    return false;
                }
            }
            if (rightUp<8){
                //考察右上角元素，第i行rightUp列有棋子吗？
                if (result[i]==rightUp){
                    return false;
                }
            }
            --leftUp;
            ++rightUp;

        }
        return true;
    }

    private void printQueens(int[] result){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i]==j){
                    System.out.println("Q ");
                }else{
                    System.out.println("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
