package com.leetcode.offer.tree;

import com.labuladong.preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-07-10 15:49
 * @Description
 * @Version 1.0
 */
public class PathSum {
    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }
        recur(root, target);
        return ans;
    }

    private void recur(TreeNode root, int target) {
        //先序遍历
        if(root == null){
            return ;
        }
        path.add(root.val);
        target-= root.val;
        if(target==0 && root.left==null && root.right==null){
            ans.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right,target);
        //回溯
        path.removeLast();
    }


}
