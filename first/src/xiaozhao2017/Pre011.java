package xiaozhao2017;

import java.util.Scanner;

public class Pre011 {

	/*
	 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，
	 * 任意两块蛋糕的欧几里得距离不能等于2。对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
	 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根小易想知道最多可以放多少块蛋糕在网格盒子里。
	 * 
	 * 
	 * 输入描述：
	 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
	 * 
	 * 输出描述
	 * 输出一个最多可以放的蛋糕数
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int[][] a = new int[row][col];
		int res = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(a[i][j]==0){
					a[i][j] = 1;
					if(i+2<row){
						a[i+2][j] = 1;
					}
					if(j+2<col){
						a[i][j+2] = 1;
					}
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
