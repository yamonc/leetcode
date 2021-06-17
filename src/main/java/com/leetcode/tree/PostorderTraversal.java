package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-05-26 8:58
 * @Description
 * @Version 1.0
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postSolution(root, ans);
        return ans;
    }
    public void postSolution(TreeNode root, List<Integer> ans){
        if (root==null){
            return;
        }
        postSolution(root.left,ans);
        postSolution(root.right, ans);
        ans.add(root.val);
    }
}
