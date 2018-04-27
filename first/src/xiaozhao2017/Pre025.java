package xiaozhao2017;

import java.util.Scanner;

public class Pre025 {
	
	/*
	 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
如果 X = 123，则rev(X) = 321;
如果 X = 100，则rev(X) = 1.
现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？

	 * */
	
	
	/*
	 * 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
	 * */
	
	/*
	 * 输出rev(rev(x) + rev(y))的值
	 * */
	public static int resverse(int n){
		String s = n+"";
		StringBuilder sb = new StringBuilder();
		int i = s.length()-1;
		while(i>=0){
			if(s.charAt(i)!=0)
				break;
		}
		
		for(int j=i;j>=0;j--){
			sb.append(s.charAt(j));
		}
		
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		
		int res = resverse(resverse(x) + resverse(y));
		System.out.println(res);
		
	}
}
