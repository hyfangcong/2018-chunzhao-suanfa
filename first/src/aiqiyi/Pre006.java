package aiqiyi;

import java.util.Scanner;

public class Pre006 {
	
	/*
	 * 考虑定义在两正整数上的函数SSR(平方根之和的平方):SSR(A, B) = (sqrt(A) + sqrt(B))^2。牛牛对函数值为
	 * 整数的情况很感兴趣。现在给定整数n和m,请帮助牛牛计算有序对(A, B)的数量, 满足1 ≤ A ≤ n, 
	 * 1 ≤ B ≤ m而且SSR(A, B)是一个整数。 
	 * 
	 * 
	 * 输入包括两个整数n和m(1 ≤ n ≤ 10^5, 1 ≤ m ≤ 10^5)
	 * 
	 * 输出一个整数,表示满足条件的有序对对数。
	 * 
	 * 
	 * 分析：如果Math.sqrt(m) = 5,则在1-m之间必定存在开方后为1,2,3,4的数字
	 * */
	
	public static void getPend(int[] pend,int a){
		for(int i=2,rec=i*i;rec<=a;i++,rec=i*i){
			if(pend[rec]==1)
				continue;
			for(int j=rec;j<=a;j+=rec){
				pend[j] = 1;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[] pend = new int[100005];
		int sm = (int)Math.sqrt(m);
		int sn = (int)Math.sqrt(n);
		int res = sm*sn;
		getPend(pend, m>n?n:m);
		
		for(int i=2;;i++){
			if(pend[i]==1)
				continue;
			if(m/i==0 || n/i==0)
				break;
			int mt = m/i;
			int nt = n/i;
			int snt = (int)Math.sqrt(nt);
			int smt = (int)Math.sqrt(mt);
			res+=snt*smt;
		}
		System.out.println(res);
	}
}
