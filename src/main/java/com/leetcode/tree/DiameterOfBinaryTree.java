package com.leetcode.tree;

public class DiameterOfBinaryTree {
	int ans;
	/**
	 * ����һ�ö�����������Ҫ��������ֱ�����ȡ�
	 * һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		ans=1;
		depth(root);
		return ans-1;
	}
	public int depth(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int L = depth(node.left);//�����������
		int R = depth(node.right);//�����������
		ans=Math.max(ans,L+R+1);
		return Math.max(L, R)+1;
		
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode L1=new TreeNode(2);
		TreeNode R1=new TreeNode(3);
		root.left=L1;
		root.right=R1;
		TreeNode L2=new TreeNode(4);
		TreeNode R2= new TreeNode(5);
		L1.left=L2;
		L1.right=R2;
		DiameterOfBinaryTree tree=new DiameterOfBinaryTree();
		int length = tree.diameterOfBinaryTree(root);
		System.out.print(length);
	}
}
