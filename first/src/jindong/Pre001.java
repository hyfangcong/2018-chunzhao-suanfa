package jindong;

import java.util.Scanner;

public class Pre001 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int [n];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
		}
		int count = 0;
		for(int i=0;i<n;i++){
			for(int gap=2;gap<n-1;gap++){
				if(a[i]>=a[(gap-1+i)%n] && a[(gap+i)%n]>=a[(gap-1+i)%n]){
					count++;
					System.out.println(i+" "+(gap+i)%n+"hh");
				}
			}
			
			for(int gap=n-2;gap>=2;gap--){
				if(a[i]>=a[(gap+1+i)%n] && a[(gap+i)%n]>=a[(gap+1+i)%n]){
					count++;
					System.out.println(i+" "+(gap+i)%n+"ww");

				}
			}
		}
		System.out.println(n+count/2);
	}
}
