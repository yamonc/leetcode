package com.newcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-10 14:21
 * @Description 描述
 * 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * 1. A为1，J为11，Q为12，K为13，A不能视为14
 * 2. 大、小王为 0，0可以看作任意牌
 * 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 例如：给出数据[6,0,2,0,4]
 * 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
 * 这样这五张牌在[2,6]区间连续，输出true
 * 数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 *
 * 示例1
 * 输入：
 * [6,0,2,0,4]
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * [0,3,2,6,4]
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例3
 * 输入：
 * [1,0,0,1,0]
 * 复制
 * 返回值：
 * false
 * 复制
 * 示例4
 * 输入：
 * [13,12,11,0,1]
 * 复制
 * 返回值：
 * false
 * @Version 1.0
 */
public class IsContinuous {
    public boolean IsContinuous(int [] numbers) {
        int joker = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++) {
            if (numbers[i]==0){
                joker++;
            }else if (numbers[i] == numbers[i+1]){
                return false;
            }
        }
        return numbers[4]-numbers[joker] < 5;
    }

    public static void main(String[] args) {
        int[] arr = {
                6,0,2,0,4
        };
        System.out.println(new IsContinuous().IsContinuous(arr));
    }
}
