package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class Test1 {
	
	
	public static void f(int[] a){
		int max = -1;
		int index = -1;
		int i=0;
		for( i=0;i<18;i++){
			int tmp = a[i]+a[i+1]+a[i+2]+a[i+3];
			if(tmp>max){
				max = tmp;
				index = i;
			}else if(tmp == max){
				if(a[i] < a[index]){
					index = i;
				}
			}
		}
		int tmp = a[i]+a[i+1]+a[i+2];
		if(tmp>max){
			max = tmp;
			index = i;
		}else if(tmp == max){
			if(a[i] < a[index]){
				index = i;
			}
		}
		
		System.out.println(a[index]);
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] a = new int[21];
		for(int i=0;i<21;i++){
			a[i] = Integer.parseInt(in.nextLine());
		}
		f(a);
	}
}
