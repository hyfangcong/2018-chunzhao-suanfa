package xiaozhao2017;

import java.util.Scanner;

public class Pre034 {
	
	/*
	 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
	 * */
	
	/*
	 * 输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。
	 * */
	
	/*
	 * 输出所求的方案数
	 * */
	
	/*
	 * 分析：动态规划中的背包问题
	 * */
	
	/*
	 * 链接：https://www.nowcoder.com/questionTerminal/7f24eb7266ce4b0792ce8721d6259800
来源：牛客网

*
 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
   解：此题使用递归的遍历方法也可以解决，但是会超时
   dp解决：
   以每个物品作为横轴，以背包容量作为纵轴
       0 1 2 3 4 5 6..........
     0 1 0 0 0 0 0 0..........
     5 1 0 0 0 0 1 0
      
      其中1表示前n件物品放入容量为M的背包有1种方法，（5，0）表示重量为5的物品放入容量为0的背包的背包有1
中方法，即不放入。0表示恰好放满背包的方法为0
      当M>weight[i]时，dp[M]=dp[M]+dp[M-weight[i]];意义是：放入物品i和不放入物品i的方法总和
	 * */
	
	static long[][] dp = new long[1001][1001];
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = in.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++){
			a[i] = in.nextInt();
		}
		//初始化数组
		//前i个数字放到大小为0的背包中只有1种方法，就是什么都不放
		for(int i=0;i<n;i++){
			dp[i][0] = 1;
		}
		
		//将0个数字放到大小为i的背包中，这样的放法为0
		for(int j=1;j<sum;j++){
			dp[0][j] = 0;
		}
		
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<=sum;j++){
				if(a[i]<=j){
					dp[i][j] = dp[i-1][j] + dp[i-1][j-a[i]];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][sum]);
	}
}
