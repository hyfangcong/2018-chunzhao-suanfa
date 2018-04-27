package wangyi;

import java.util.Scanner;

public class Pre001 {
	
	/*
	 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器
	 * 可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
	 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
	 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
	 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入
	 * 方案使他最后恰好拥有n个魔法币。
	 * 
	 * 
	 * 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
	 * 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
	 * 例：输入：10
	 * 	输出：122
	 * 
	 * 
	 * */
	
	/*
	 * 深度优先搜索的时候，遍历到终点，然后返回的时候在访问。
	 * 
	 * 在满足条件的那条路径上就访问该路径的节点，
	 * 对于不满足条件的路径上的节点就不访问。
	 * */
	
	public static boolean DFS(int n,int k,StringBuilder sb){
		if(n>k){
			return false;
		}
		if(n==k){
			return true;
		}
		
		if(DFS(n*2+1, k,sb)){
			sb.append("1");
			return true;
		}
		
		if(DFS(n*2+2, k, sb)){
			sb.append("2");
			return true;
		}
		return false;
	}
	
	
	/*
	 * 解法二：利用机器1只能产生奇数的魔法币，机器2只能产生偶数的魔法币。
	 * 从n向前推，n%2==0只能有机器2产生，n%2==1只能有机器1产生。
	 * */
	
	public static void f2(){
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		while(n>0){
			if(n%2==0){
				n = (n-2)/2;
				sb.append("2");
			}else{
				n = (n-1)/2;
				sb.append("1");
			}
		}
		System.out.println(sb.reverse().toString());
		in.close();
	}
	
	
	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int k = in.nextInt();
//		
//		StringBuilder sb = new StringBuilder();
//		
//		DFS(0, k, sb);
//		System.out.println(sb.reverse().toString());
		f2();
	
		
		
	}
}
