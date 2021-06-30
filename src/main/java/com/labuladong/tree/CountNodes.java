package com.labuladong.tree;

import com.labuladong.preDefine.TreeNode;

/**
 * @Author yamon
 * @Date 2021-06-28 14:29
 * @Description 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class CountNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    public static void main(String[] args) {
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode l = new TreeNode(2,ll,lr);
        TreeNode r = new TreeNode(3,null,rl);
        TreeNode root = new TreeNode(1,l,r);
        System.out.println(new CountNodes().countNodes(root));
    }
}
