package com.leetcode.everyday.a202108;

import com.labuladong.preDefine.TreeNode;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-31 10:35
 * @Description 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class VerticalTraversal {
    /*
     * 整体思路：排序+哈希表。排序顺序按照列号从小到大，
     * 对于同列节点，行号从小大大，对于同行同列元素，按照节点值从小到大排序
     * 首先对树进行遍历，然后记录节点的信息值，然后按照规则排序。
     * */
    Map<TreeNode, int[]> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        //dfs根据树中的左右节点信息构造到map中
        dfs(root);
        //现在map中已经存放了各个节点的信息，将map中的values数据放在list中
        List<int[]> list = new ArrayList<>(map.values());
        //开始排序
        Collections.sort(list, (a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });
        int n = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n;) {
            int j = i;
            List<Integer> temp = new ArrayList<>();
            while (j<n && list.get(j)[0]==list.get(i)[0]){
                temp.add(list.get(j++)[2]);
            }
            ans.add(temp);
            i=j;
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //首先从map中获取到根节点
        int[] info = map.get(root);
        int col = info[0], row = info[1], val = info[2];
        //开启深度优先遍历
        if (root.left != null) {
            //将当前节点的信息存放在map中，构造规则：左节点应该是列-1,
            map.put(root.left, new int[]{col - 1, row+1, root.left.val});
            //开启深度遍历，递归访问左节点
            dfs(root.left);
        }
        if (root.right != null) {
            //将当前的节点存放在map中，苟泽规则：右节点应该是row-1
            map.put(root.right, new int[]{col+1, row + 1, root.right.val});
            //开启深度遍历，递归访问右节点
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode  r= new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(6);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right=r;
        r.left=rl;
        r.right=rr;
        l.left=ll;
        l.right=lr;
        new VerticalTraversal().verticalTraversal(root);
    }

}
