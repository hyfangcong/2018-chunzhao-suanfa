package aiqiyi;

import java.util.Scanner;

public class Pre004 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String x1 = in.next();
		int k1 = in.nextInt();
		String x2 = in.next();
		int k2 = in.nextInt();
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i=0;i<k1;i++){
			sb1.append(x1);
		}
		for(int i=0;i<k2;i++){
			sb2.append(x2);
		}
		String s1 = sb1.toString();
		String s2 = sb2.toString();
		if(s1.length()>s2.length()){
			System.out.println("Greater");
		}else if(s1.length()<s2.length()){
			System.out.println("Less");
		}else{
			if(s1.compareTo(s2)>0){
				System.out.println("Greater");
			}else if(s1.compareTo(s2)<0){
				System.out.println("Less");
			}else {
				System.out.println("Equal");
			}
		}
	
		
	}
}
