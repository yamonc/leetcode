package com.labuladong.houseRobber;

import com.labuladong.preDefine.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-06-21 19:56
 * @Description
 * @Version 1.0
 */
public class RobIII_1 {
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root){

        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        //抢，去下下家
        int do_it = root.val+
                (root.left==null ? 0:rob(root.left.left)+rob(root.left.right))
                +(root.right==null ? 0 : rob(root.right.left)+rob(root.right.right));
        //不抢,去下一家
        int notDoIt = rob(root.left)+rob(root.right);
        int ans = Math.max(do_it, notDoIt);
        memo.put(root, ans);
        return ans;
    }

}
