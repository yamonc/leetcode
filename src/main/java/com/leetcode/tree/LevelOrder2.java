package com.leetcode.tree;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-05-21 8:23
 * @Description 剑指 Offer 32 - I. 从上到下打印二叉树
 * 上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
返回其层次遍历结果：

[
[3],
[9,20],
[15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int currentQueueSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (currentQueueSize>0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                currentQueueSize--;
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left=new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left=left;
        root.right=right;
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        right.left=rightLeft;
        right.right=rightRight;
        new LevelOrder2().levelOrder(root);
    }
}
