package wangyi;

import java.util.Scanner;

public class Pre002 {
	
	/*
	 * 一个整数的“相反数”和他自己相加的值。
	 * 
	 * 如果“相反数”的前面有0，去掉最前面的0.
	 * 
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String string = n+"";
		String s2 = new StringBuilder(string).reverse().toString();
		int i=0;
		while(s2.charAt(i)=='0'){
			i++;
		}
		int n2 = Integer.parseInt(s2.substring(i));
		System.out.println(n+n2);
		in.close();
	}
}
