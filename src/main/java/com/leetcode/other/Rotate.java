package com.leetcode.other;



import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2020-12-19 9:11
 * @Description 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * @Version 1.0
 */
public class Rotate {
    public static void rotate(int[][] matrix){
        Queue<Integer> queue = new LinkedList<Integer>();
        int count=0;
        int count1=0;
        //遍历数组将数组存进队列中
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count++;
                queue.add(matrix[i][j]);
            }
        }
        for(int g=0;g<matrix.length;g++){
            for(int j=0;j<matrix[g].length;j++) {
                for(int i=0;i<matrix.length;i++){

                    if(count1<count){
                        matrix[i][j]= queue.poll();
                        count1++;
                    }
                }
            }
        }
        System.out.println(queue);
    }
    public static void main(String[] args) {
        int[][] arr2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(arr2);




    }
}
