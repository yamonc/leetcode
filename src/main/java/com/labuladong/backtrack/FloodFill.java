package com.labuladong.backtrack;

/**
 * @Author yamon
 * @Date 2021-06-30 15:12
 * @Description 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 *
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 *
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 *
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr,sc, image[sr][sc], newColor);
        return image;
    }
    void fill(int[][] image, int x, int y, int originColor, int newColor){
        //出界，超出数组范围
        if(!inArea(image,x,y)){
            return ;
        }
        //碰壁,遇到其他颜色或者查出originColor区域
        if(image[x][y] != originColor){
            return;
        }
        //已经探索过的orginColor区域
        if(image[x][y] ==-1){
            return ;
        }
        //选择，开始打标记，预防重复
        image[x][y] = -1;
        fill(image,x,y+1,originColor, newColor);
        fill(image,x+1,y,originColor, newColor);
        fill(image,x-1,y,originColor, newColor);
        fill(image,x,y-1,originColor, newColor);
        //取消选择
        image[x][y] = newColor;
    }
    boolean inArea(int[][] image, int x, int y ){
        return x>=0 && x< image.length && y>=0 && y<image[0].length;
    }
}
