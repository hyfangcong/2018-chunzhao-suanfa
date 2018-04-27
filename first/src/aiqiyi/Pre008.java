package aiqiyi;

import java.util.Scanner;

public class Pre008 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			int n = in.nextInt();
			if(n%2==0){
				System.out.println("yang");
			}else{
				System.out.println("niu");
			}
		}
	}
}
