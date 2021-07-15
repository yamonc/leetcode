package com.leetcode.offer.tree;

import com.labuladong.preDefine.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-07-10 16:32
 * @Description 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class KthLargest {
    private Stack<Integer> stack = new Stack<>();
    public int kthLargest(TreeNode root, int k) {
        //整体思路：先序遍历二叉树，在先序的过程中将节点值存入栈中，然后按照倒数k取值即可
        inorder(root);
        int count =0;
        while (!stack.isEmpty()){
            //当栈不为空
            ++count;
            if(count!=k){
                stack.pop();
            }else{
                return stack.pop();
            }
        }
        return 0;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        stack.push(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(3);
        TreeNode r = new TreeNode(6);
        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(4);
        TreeNode lll = new TreeNode(1);
        root.left=l;
        root.right= r;
        l.left=ll;
        l.right=lr;
        ll.left=lll;
        System.out.println(new KthLargest().kthLargest(root, 3));
    }
}
