package com.leetcode.everyday.a202108;
import static java.lang.Math.*;
/**
 * @Author yamon
 * @Date 2021-08-22 15:17
 * @Description
 * @Version 1.0
 */
public class EscapeGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        int distance = manhattanDistance(source, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost, target);
            if (ghostDistance <= distance) {
                return false;
            }
        }
        return true;
    }

    private int manhattanDistance(int[] source, int[] target) {
        return abs(source[0]-target[0])+abs(source[1]-target[1]);
    }


}
