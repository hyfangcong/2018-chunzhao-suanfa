package aiqiyi;

import java.util.Scanner;

public class Pre002 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int count = 0;
		int res = 0;
		for(int i=0;i<s.length();i++){
			
			if(s.charAt(i)=='('){
				count++;
			}else{
				count--;
			}
			
			if(count == -1){
				count = 0;
				res++;
			}
		}
		
		System.out.println(res+count);
	}
}
