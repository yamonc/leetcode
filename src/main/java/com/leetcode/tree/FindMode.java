package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FindMode {
	
	
	List<Integer> answer = new ArrayList<Integer>();
	int base,count,maxCount;
	
	public int[] findMode(TreeNode root) {
		dfs(root);
		int[] mode = new int[answer.size()];
		for(int i=0;i<answer.size();i++) {
			mode[i]=answer.get(i);
		}
		return mode;
	}
	
	public void dfs(TreeNode o) {

		if(o==null) {
			return;
		}
		dfs(o.left);
		update(o.val);
		dfs(o.right);
	}
	
	public void update(int x) {
		if(x == base) {
			++count;
		}else {
			count=1;
			base=x;
		}
		if(count==maxCount) {
			answer.add(base);
		}
		if(count>maxCount) {
			maxCount=count;
			answer.clear();
			answer.add(base);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(0);
		TreeNode right = new TreeNode(2);
		TreeNode leftleft=new TreeNode(-1);
		TreeNode leftRight=new TreeNode(0);
		TreeNode rightLeft=new TreeNode(2);
		root.left=left;
		root.right=right;
		left.left=leftleft;
		left.right=leftRight;
		right.left=rightLeft;
		new FindMode().findMode(root);
	}

}
