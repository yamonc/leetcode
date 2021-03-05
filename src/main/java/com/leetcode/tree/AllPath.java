package com.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-02-24 10:30
 * @Description 二叉树的路径遍历，深度优先搜索
 * @Version 1.0
 */
public class AllPath {


    public List<String> binaryTreePath(TreeNode node){
        List<String> paths = new ArrayList<>();
        constructPaths(node,"",paths);
        return paths;
    }

    public void constructPaths(TreeNode root,String path, List<String> paths){
        if (root!=null){
            //开始遍历
            //初始化路径
            StringBuffer pathSb = new StringBuffer(path);
            pathSb.append(Integer.toString(root.val));
            if (root.left==null && root.right==null){
                //没有子树，只有根
                paths.add(pathSb.toString());
            }else{
                //有子树，遍历子树，如果当前节点不是叶子节点，继续递归遍历
                pathSb.append("->");
                constructPaths(root.left,pathSb.toString(),paths);
                constructPaths(root.right,pathSb.toString(),paths);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val=1;
        node.left=new TreeNode();
        node.right=new TreeNode();
        node.left.val=2;
        node.right.val=3;
        node.left.right=new TreeNode();
        node.left.right.val=5;
    }
}
