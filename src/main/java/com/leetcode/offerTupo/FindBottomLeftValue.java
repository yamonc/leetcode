package com.leetcode.offerTupo;

import com.labuladong.preDefine.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-08-29 16:07
 * @Description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 *
 * 提示:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
         Queue<TreeNode> queue = new ArrayDeque<>();
         if (root == null){
             return 0;
         }
         queue.offer(root);
         int ans = 0;
         while (!queue.isEmpty()){
             int size = queue.size();
             for (int i = 0;i<size;i++){
                 final TreeNode poll = queue.poll();
                 if (i==0){
                     ans = poll.val;
                 }
                 if (poll.left!=null){
                     queue.offer(poll.left);
                 }
                 if (poll.right!=null){
                     queue.offer(poll.right);
                 }
             }
         }
         return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        root.left=l;
        root.right = r;
        l.left= ll;
        l.right=lr;
        new FindBottomLeftValue().findBottomLeftValue(root);

    }
}
