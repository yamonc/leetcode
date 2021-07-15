package com.leetcode.offer.tree;






import com.labuladong.preDefine.TreeNode;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-07-10 14:26
 * @Description
 * @Version 1.0
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //广度优先遍历树，然后输出成字符串
        //利用队列实现
        if(root == null){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        //先将root存入队列中
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //再将node的左节点存入对列
            if(node!=null){
                stringBuilder.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                //当节点为空
                stringBuilder.append("null,");
            }
        }
        //删除最后一个逗号
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //特判，如果是空的
        if(data.equals("[]")){
            return null;
        }
        //从第一个位置开始到最后一个位置，按照逗号分开
        String[] vals = data.substring(1, data.length()-1).split(",");
        //将数组中的第一个转换为TreeNode节点
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        //创建队列，并将第一个放进队列中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        new Codec().deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
    }
}
