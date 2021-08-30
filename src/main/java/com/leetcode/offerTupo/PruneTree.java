package com.leetcode.offerTupo;

import com.labuladong.preDefine.TreeNode;

/**
 * @Author yamon
 * @Date 2021-08-30 14:35
 * @Description
 * @Version 1.0
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean a1 = containsOne(root.left);
        boolean a2 = containsOne(root.right);
        if (!a1){
            root.left = null;
        }
        if (!a2){
            root.right = null;
        }
        return root.val == 1 || a1 || a2;
    }
}
