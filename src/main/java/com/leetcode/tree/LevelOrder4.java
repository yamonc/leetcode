package com.leetcode.tree;

import java.sql.PreparedStatement;
import java.util.*;

/**
 * @Author yamon
 * @Date 2021-05-21 8:23
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树


 
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

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
[20,9],
[15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
使用层序遍历和双端队列，奇偶层逻辑分离
        BFS 循环： 循环打印奇 / 偶数层，当 deque 为空时跳出；
        打印奇数层： 从左向右 打印，先左后右 加入下层节点；
        若 deque 为空，说明向下无偶数层，则跳出；
        打印偶数层： 从右向左 打印，先右后左 加入下层节点；

作者：jyd
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class LevelOrder4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        deque.add(root);
        while (!deque.isEmpty()){
            // 打印奇数层
            List<Integer> temp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                //从左向右打印
                TreeNode node = deque.removeFirst();
                temp.add(node.val);
                //先左后右添加下层节点
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            res.add(temp);
            if (deque.isEmpty()) break;
            //打印偶数层
            temp = new ArrayList<>();
            for (int i = deque.size(); i >0 ; i--) {
                //从右向左打印
                TreeNode node = deque.removeLast();
                temp.add(node.val);
                //从右向左添加节点
                if (node.right!=null){
                    deque.addFirst(node.right);
                }
                if (node.left!=null){
                    deque.addFirst(node.left);
                }
            }
            res.add(temp);
        }
        return res;
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
        System.out.println(new LevelOrder4().levelOrder(root));
    }
}
