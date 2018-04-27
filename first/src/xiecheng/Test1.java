package xiecheng;

import java.util.Scanner;

public class Test1 {
	
	public static void f(int[] a){
		int j=0;
		for(int i=0;i<a.length;i++){
			while(a[j]!=0 && j<a.length){
				j++;
			}
			i=j+1;
			while(a[i]==0 && i<a.length){
				i++;
			}
			a[j] = a[i];
			a[i] = 0;
			j++;
		}
	}
	
	
	
	public static void main(String[] args){
		Scanner in = new  Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		
		int[] a = new int[n];
		int i=0;
		for(i=0;i<n;i++){
			a[i] = Integer.parseInt(in.nextLine());
		}
		
		f(a);
		for(int j=0;j<a.length;j++){
			System.out.println(a[j]);
		}
		
	}
}
