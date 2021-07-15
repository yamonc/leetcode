package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-15 16:24
 * @Description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReversePairs {
    int[] nums, temp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int l, int r) {
        //终止条件
        if (l >= r) {
            return 0;
        }
        //递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        //合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for(int k = l;k<=r;k++){
            if(i==m+1){
                nums[k] = temp[j++];
            }else if(j==r+1 || temp[i]<=temp[j]){
                nums[k] = temp[i++];
            }else{
                nums[k] = temp[j++];
                //统计逆序对儿
                res += m-i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println(new ReversePairs().reversePairs(arr));
    }
}
