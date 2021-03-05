package com.leetcode.everyday;

public class Transpose {
	
	
	public int[][] transpose(int[][] matrix){
		//创建一个临时矩阵
		int m=matrix[0].length;
		int n = matrix.length;
		int[][] tempM= new int[m][n];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				//
				if(i==j) {
					tempM[i][j]=matrix[i][j];
				}else {
					tempM[j][i] = matrix[i][j];
				}
				
			}
		}
		return tempM;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		new Transpose().transpose(a);
	}

}
