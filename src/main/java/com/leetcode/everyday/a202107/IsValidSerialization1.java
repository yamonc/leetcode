package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2021-03-12 8:43
 * @Description
 * @Version 1.0
 */

public class IsValidSerialization1 {

    public boolean isValidSerialization(String preorder) {
        final String[] temp = preorder.split(",");
        if (temp[0].equals("#") && temp.length == 1){
            return true;
        }
        if (temp[0].equals("#") || temp.length%2==0){
            return false;
        }
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            count--;
            if (count<0){
                return false;
            }
            if (!temp[i].equals("#")){
                count+=2;
            }
        }
        return count==0;
    }

    public static void main(String[] args) {
        new IsValidSerialization1().isValidSerialization("9,#,#,1");
    }
}
