package aiqiyi;

import java.util.Scanner;

public class Test002 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int max = Math.max(a, b);
		max = Math.max(max, c);
		int count = 0;
		int tmp = a;
		while(a<=max-2){
			a+=2;
			count++;
		}
		while(b<=max-2){
			b+=2;
			count++;
		}
		while(c<=max-2){
			c+=2;
			count++;
		}
		
		int tag = (max-a) + (max-b) + (max-c);
		if(tag==0){
			System.out.println(count);
		}else if(tag==3){
			System.out.println(count+3);
		}else if(tag==2){
			System.out.println(count+1);
		}else{
			System.out.println(count+2);
		}
	}
}
