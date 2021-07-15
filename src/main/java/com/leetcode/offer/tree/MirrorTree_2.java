package com.leetcode.offer.tree;

import com.labuladong.preDefine.TreeNode;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-07-08 15:20
 * @Description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 12.0 栈
 */
public class MirrorTree_2 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        //首先加入根节点
        stack.push(root);
        // 循环交换
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            //添加子节点，将node左右子节点加入栈中
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            //交换节点
            TreeNode temp = node.left;
            node.left=node.right;
            node.right = temp;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode al = new TreeNode(2);
        TreeNode ar = new TreeNode(7);
        TreeNode all = new TreeNode(1);
        TreeNode alr = new TreeNode(3);
        TreeNode arl = new TreeNode(6);
        TreeNode arr = new TreeNode(9);
        a.left= al;
        a.right=ar;
        al.left=all;
        al.right=alr;
        ar.left= arl;
        ar.right=arr;
        System.out.println(new MirrorTree_2().mirrorTree(a));
    }


}
