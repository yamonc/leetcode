package com.labuladong.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-06-24 16:08
 * @Description 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * <p>
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * <p>
 * 返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * <p>
 * 返回 false。因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        //左下角定点,记录最小值
        int X1= Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        //右上角顶点，记录最大值
        int X2= Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;
        //找出左上角和右上角顶点坐标
        int actualArea = 0;
        //记录顶点出现的信息
        Set<String> point = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            X1 = Math.min(x1, X1);
            Y1 = Math.min(y1, Y1);
            X2 = Math.max(x2, X2);
            Y2 = Math.max(y2, Y2);
            //计算每个长方形的面积
            actualArea += (x2-x1) * (y2-y1);
            //判断顶点是否出现过
            String[] ps = {
                    x1+" "+y1, x2+" "+y2, x1+" "+y2, x2+" "+y1
            };
            for (String s : ps) {
                //没有出现过，添加。否则 移除
                if (point.contains(s)){
                    point.remove(s);
                }else{
                    point.add(s);
                }
            }
        }
        //计算完美矩形和实际的所有矩形是否相等：
        int expectedArea = (X2-X1) * (Y2-Y1);
        if (actualArea!=expectedArea){
            return false;
        }
        //判断顶点是否满足
        if (point.size()!=4){
            return false;
        }
        if (!point.contains(X1+" "+Y1)){
            return false;
        }
        if (!point.contains(X2+" "+Y2)){
            return false;
        }
        if (!point.contains(X1+" "+Y2)){
            return false;
        }
        if (!point.contains(X2+" "+Y1)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr ={
                {1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}
        };
        System.out.println(new IsRectangleCover().isRectangleCover(arr));
    }
}
