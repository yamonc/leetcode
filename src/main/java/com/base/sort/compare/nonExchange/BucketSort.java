package com.base.sort.compare.nonExchange;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-02 16:38
 * @Description
 * @Version 1.0
 */
public class BucketSort {
    public void bucketSort(int[] arr){
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            buckets.add(new ArrayList<>());
        }
        //首先，将数组中的元素加入到桶中
        for (int item : arr) {
            //桶号
            int index = item / 10;
            //将数字添加到对应的桶号中
            buckets.get(index).add(item);
        }
        //对每个桶内进行排序
        for (List<Integer> bucket : buckets) {
            bucket.sort(null);
            for (int j = 0; j < bucket.size(); j++) {
                //打印输出
                System.out.println(bucket.get(j) + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 15,22,30, 1, 4,29, 80,90, 92,85,36};
        new BucketSort().bucketSort(arr);
    }
}
