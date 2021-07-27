package com.leetcode.offer;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-27 10:39
 * @Description输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 大顶堆
 */
public class GetLeastNumbers_TreeMap {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        /*
        * 使用TreeMap，key是数组中的数字。value是数字出现的个数
        * 我们遍历数组中的每个数字，维护一个数字总个数为k的TreeMap
        * 1. 如果map中的数字个数小于K，则将map中当前的数字对应的个数+1
        * 2. 否则，判断当前数字与map中最大的数字的大小关系，如果当前数字大于等于map中的最大的数字，则跳过。
        * 如果当前的数字小于map中的最大数字，则将map中当前数字对应的个数+1,，并将map中的最大数字对应的个数-1
        *
        * */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for(int num : arr){
            //1. 遍历数组，如果当前map中的数字小于K，则map中的当前数字个数加1
            if(cnt<k){
                map.put(num, map.getOrDefault(num, 0)+1);
                cnt++;
                continue;
            }
            //2. 否则，取出map中最大的key，判断当前数字与map中最大数字的大小关系
            //如果当前数字比map最大的数字还大，忽略，否则，将当前的数组加入map中，并将map中之前最大的数字个数-1
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if(entry.getKey()>num){
                map.put(num,map.getOrDefault(num,0)+1);
                if(entry.getValue()==1){
                    map.pollLastEntry();
                }else{
                    map.put(entry.getKey(), entry.getValue()-1);
                }
            }
        }
        //最后返回map中的数字
        int[] res = new int[k];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int freq = entry.getValue();
            while(freq-- > 0){
                res[idx++] = entry.getKey();
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new GetLeastNumbers_TreeMap().getLeastNumbers(arr, 4)));
    }
}
