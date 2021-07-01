package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-01 16:12
 * @Description 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left  = getMax(weights);
        int right = getSum(weights)+1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(canFinish(weights, days, mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    //如果载重为cap，能够在days内运完货物
    boolean canFinish(int[] weights, int days, int cap){
        int i = 0;
        for(int day = 0;day<days;day++){
            int maxCap = cap;
            while((maxCap -= weights[i])>=0){
                i++;
                if(i==weights.length){
                    return true;
                }
            }
        }
        return false;
    }
    int getMax(int[] weights){
        int max = 0;
        for(int w : weights){
            max = Math.max(max, w);
        }
        return max;
    }
    int getSum(int[] weights){
        int sum  = 0;
        for(int w: weights){
            sum+=w;
        }
        return sum;
    }
}