package com.test;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-30 19:42
 * @Description
 * @Version 1.0
 */
public class Max_version {

    public int[] max_version(String[][] version_list) {
        // write code here
        int[] ans = new int[version_list.length];
        int idx = 0;
        for (String[] version : version_list) {
            String va = version[0];
            String vb = version[1];
            String[] a = va.split("\\.");
            String[] b = vb.split("\\.");
            int i1, i2;
            for (int i = 0; i < Math.max(a.length, b.length); i++) {
                i1 = i < a.length ? Integer.parseInt(a[i]) : 0;
                i2 = i < b.length ? Integer.parseInt(b[i]) : 0;
                if (i1 != i2) {
                    if(i1>=i2){
                        ans[idx] = 1;
                    }else{
                        ans[idx] = 2;
                    }
                    idx++;
                    break;
                }else{
                    //如果两个相同的话，直接赋值为1
                    ans[idx]=1;
                    idx++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"0.1.0", "1.0"},
                {"2.1.13", "1.20.0"},
                {"2.1.0", "2.1.0"}
        };
        System.out.println(Arrays.toString(new Max_version().max_version(arr)));
    }
}
