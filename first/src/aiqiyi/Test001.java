package aiqiyi;

import java.util.Scanner;

public class Test001 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(int i=0;i<s.length();){
			index = i;
			for(int j=i;j<s.length();j++){
				if(s.charAt(j)>s.charAt(index)){
					index = j;
				}
			}
			sb.append(s.charAt(index));
			i = index + 1;
		}
		System.out.println(sb.toString());
	}
}
