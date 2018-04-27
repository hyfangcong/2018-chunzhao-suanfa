package xiaozhao2017;

import java.util.Scanner;

public class Pre027 {
	
	/*
	 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 
	 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将
	 * 不会购买。
	 * */
	
	/*
	 * 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
	 * */
	
	/*
	 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] dp = new int[n+1];
		for(int i=0;i<dp.length;i++){
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[n] = 0;
		for(int i=n;i>=6;i--){
			if(dp[i]==Integer.MAX_VALUE)
				continue;
			int tmp = i;
			if(tmp-6>=0){
				dp[tmp-6] = Math.min(dp[tmp-6], dp[tmp]+1);
			}
			if(tmp-8>=0){
				dp[tmp-8] = Math.min(dp[tmp-8], dp[tmp]+1);
			}
		}
		if(dp[0]==Integer.MAX_VALUE){
			System.out.println(-1);
		}else {
			System.out.println(dp[0]);
		}
	}
}
