package com.leetcode.offerTupo;

import com.labuladong.preDefine.TreeNode;
import com.leetcode.everyday.preDefine.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-08-30 14:40
 * @Description
 * @Version 1.0
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder();
        sb.append("[");
        if (root==null){
            sb.append("]");
            return sb.toString();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                sb.append("null,");
            }

        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")){
            return null;
        }
        data = data.substring(1, data.length()-1);
        String[] vals = data.split(",");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
