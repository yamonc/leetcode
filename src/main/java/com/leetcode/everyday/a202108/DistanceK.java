package com.leetcode.everyday.a202108;

import com.labuladong.preDefine.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-07-28 10:28
 * @Description 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class DistanceK {
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //从root出发，dfs，记录每个节点的父节点
        findParents(root);
        //从target出发dfs，寻找所有深度为k的节点
        findAns(target, null, 0, k);
        return ans;
    }
    public void findParents(TreeNode root){
        if(root.left!=null){
            parents.put(root.left.val, root);
            findParents(root.left);
        }
        if(root.right!=null){
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }
    public void findAns(TreeNode root, TreeNode from, int depth, int k){
        if(root == null){
            return ;
        }
        if(depth==k){
            ans.add(root.val);
        }
        //递归dfs
        if(root.left!=from){
            findAns(root.left, root, depth+1, k);
        }
        if(root.right!=from){
            findAns(root.right, root, depth+1, k);
        }
        if(parents.get(root.val) != from){
            findAns(parents.get(root.val), root, depth+1, k);
        }
    }
}
