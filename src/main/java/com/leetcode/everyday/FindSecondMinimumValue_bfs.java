package com.leetcode.everyday;

import com.labuladong.preDefine.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-07-27 10:12
 * @Description 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 bfs广度优先搜索
 */
public class FindSecondMinimumValue_bfs {
    Set<Integer> set = new HashSet<Integer>();
    public int findSecondMinimumValue(TreeNode root) {
        bfs(root);
        if(set.size()<2){
            return -1;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i :set){
            if(i<=first){
                second = first;
                first = i;
            }else if(i <= second){
                second=i;
            }
        }
        return second;
    }

    public void bfs(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            set.add(poll.val);
            if(poll.left!=null){
                queue.addLast(poll.left);
            }
            if(poll.right!=null){
                queue.addLast(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode r = new TreeNode(5);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(7);
        root.left = left;
        root.right=r;
        r.left=rl;
        r.right=rr;
        System.out.println(new FindSecondMinimumValue_bfs().findSecondMinimumValue(root));
    }
}
