package com.leetcode.offer.tree;

import com.labuladong.preDefine.TreeNode;

/**
 * @Author yamon
 * @Date 2021-07-08 14:54
 * @Description
 * @Version 1.0
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A!=null && B!=null) &&(helper(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right, B));
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if(b==null) {
            return true;
        }
        if(a==null || a.val != b.val){
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode al = new TreeNode(4);
        TreeNode ar = new TreeNode(5);
        TreeNode all = new TreeNode(1);
        TreeNode alr = new TreeNode(2);
        a.left= al;
        a.right=ar;
        al.left=all;
        al.right=alr;
        TreeNode b = new TreeNode(4);
        TreeNode bl = new TreeNode(1);
        b.left=bl;
        System.out.println(new IsSubStructure().isSubStructure(a, b));
    }


}
