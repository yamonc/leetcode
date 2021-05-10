package com.leetcode.other;

/**
 * @Author yamon
 * @Date 2021-04-01 15:32
 * @Description
 * @Version 1.0
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int curIndex = first;
        while (curIndex < last && sequence[curIndex] <= rootVal) {
            curIndex++;
        }
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }

    public static void main(String[] args) {
        final int[] sequence = {7,4,6,5};
        new VerifySquenceOfBST().VerifySquenceOfBST(sequence);
    }
}
