package xiaozhao2017;

import java.util.Scanner;

public class Pre050 {
	
	/*
	 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，
	 * 计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
	 * */
	
	/*
	 * 输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
	 * */
	
	/*
	 * 输出包括一行，为走法的数目。
	 * */
	
	static int res = 0;
	public static void dfs(int x, int y, int m,int n){
		if(x==m && y==n){
			res++;
		}
		if(x+1<=m){
			dfs(x+1, y, m, n);
		}
		if(y+1<=n){
			dfs(x, y+1, m, n);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		dfs(0, 0, m, n);
		System.out.println(res);
	}
	
}
