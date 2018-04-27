package wangyi;

import java.util.Scanner;

public class Pre003 {
	/*
	 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:
	 * 'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		double count=1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i-1)!=s.charAt(i)){
				count++;
			}
		}
		
		
		in.close();
		System.out.printf("%.2f",s.length()/count);
	}
}
