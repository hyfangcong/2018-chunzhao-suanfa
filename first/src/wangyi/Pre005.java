package wangyi;

import java.util.Scanner;

public class Pre005 {
	
	/*
	 * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。小易现在在0号城市,
	 * 每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。如果小易到达过某个城市
	 * 就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,请你帮他计算一下他
	 * 最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
	 * 
	 * 
	 * 输入描述：
	 * 输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
	 * 第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市
	 * 和parent[i]间有一条道路连接。
	 * 
	 * 输出一个整数,表示小易最多能游历的城市数量。
	 * 
	 * 
	 * 
	 * 
	 * 分析：
	 * 只要找到最长的一条路径就好，只要保证最长路径只走一次，多余的步数再去访问其他节点，就能计算能够访问的最多节点数。
	 * (1) 如果允许走的步数L小于等于最长路径，那么就直接只在最长路径上走，这样可以不重复地走完，步数为走过的边数count，
	 * 经过的点数为 count+1
	 * (2) 如果允许走的步数L大于最长路径，那么意味着可以往回走。
	 * 越短的树链往回走的代价越低，所以先消耗富余的步数走最短的树链，然后在走最长的树链。
	 * 
	 * 所以其他路径上的点数为(L-maxDepth)/2，maxDepth为树的深度，也就是最长路径上的边数。
	 * 此时经过的点数为maxDepth+(L-maxDepth)/2+1，如果点数大于n，则输出n，否则直接输出总点数。
	 * */
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int L = in.nextInt();
		int[] depth = new int[n];
		int[] parent = new int[n];
		int maxDepth=0;
		for(int i=0;i<n-1;i++){
			parent[i] = in.nextInt();
		}
		in.close();
		for(int i=0;i<n-1;i++){
			depth[i+1] = depth[parent[i]]+1;
			if(depth[i+1]>maxDepth){
				maxDepth = depth[i+1];
			}
		}
		
		if(maxDepth>=L){
			System.out.println(L+1);
		}else {
			int count = maxDepth+(L-maxDepth)/2;
			if(count>n)
				count = n;
			System.out.println(count+1);
		}
	}
}
