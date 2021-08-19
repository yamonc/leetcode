package com.test;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-30 19:21
 * @Description
 * @Version 1.0
 */
public class CountMaxActivity {

    public int countMaxActivity(ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        int[][] events = new int[timeSchedule.size()][2];
        for (int i = 0; i < timeSchedule.size(); i++) {
            ArrayList<String> temp = timeSchedule.get(i);
            events[i][0] = Integer.parseInt(temp.get(0).replace(":",""));
            events[i][1] = Integer.parseInt(temp.get(1).replace(":", ""));
        }
        //排序,直接比较数字的大小
        Arrays.sort(events, Comparator.comparingInt(o->o[0]));
        int ans = 1;
        int n = events.length;
        int right =events[0][1];

        for(int i = 1;i<n;i++){
            if(events[i][0]>=right){
                ans++;
                right = events[i][1];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        ArrayList<String> tem1 = new ArrayList<>();
        tem1.add("10:00");
        tem1.add("12:00");

        ArrayList<String> tem2 = new ArrayList<>();
        tem2.add("03:00");
        tem2.add("11:30");
        ArrayList<String> tem3 = new ArrayList<>();
        tem3.add("11:30");
        tem3.add("14:00");
        arr.add(tem1);
        arr.add(tem2);
        arr.add(tem3);
        System.out.println(new CountMaxActivity().countMaxActivity(arr));

    }
}
