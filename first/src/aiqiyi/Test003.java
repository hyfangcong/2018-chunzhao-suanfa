package aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Test003 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[][] a = new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		
		/*
		 * 先将所有的下限的糖果都放到盒子中，求出剩余还能放多少个糖果
		 * 然后用一个一维数组记录每种糖果的上限值-下限值
		 * */
		int[] b = new int[n];
		for(int i=0;i<n;i++){
			m-=a[i][0];
			b[i] = a[i][1]-a[i][0];
		}
		Arrays.sort(b);
		
		/*
		 * 然后按照只放0种糖果就能够放满m个，只放1种，2种，3种，一直到n种
		 * 求出每个情况下对应的种数，然后相加即可得到结果
		 * 
		 * */
		long res = 0;
		if(m==0){
			System.out.println(1);
			return;
		}
		for(int i=1;i<=n;i++){
			 
		}
	}
}
