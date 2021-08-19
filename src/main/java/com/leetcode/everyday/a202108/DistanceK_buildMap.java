package com.leetcode.everyday.a202108;

import com.labuladong.preDefine.TreeNode;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-28 10:28
 * @Description 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class DistanceK_buildMap {
    int N = 1010, M = N * 2;
    int[] he = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    boolean[] vis = new boolean[N];

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(target.val);
        vis[target.val] = true;
        while (!d.isEmpty() && k >= 0) {
            int size = d.size();
            while (size-- >0){
                int poll = d.pollFirst();
                if(k==0){
                    ans.add(poll);
                    continue;
                }
                for(int i = he[poll];i!=-1;i=ne[i]){
                    int j = e[i];
                    if(!vis[j]){
                        d.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }

}
