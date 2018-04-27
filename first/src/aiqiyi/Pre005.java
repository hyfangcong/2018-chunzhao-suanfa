package aiqiyi;

import java.util.Scanner;

public class Pre005 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int max = 0;
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				count++;
				if(count>max){
					max = count;
				}
			}else{
				count--;
			}
		}
		System.out.println(max);
	}
}
