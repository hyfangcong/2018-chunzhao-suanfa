package jindong;

import java.util.Scanner;
import java.util.Stack;

public class Pre002 {
	
	public static int maxDivide(int a,int b){
		int value = 1;
		int min=0;
		if(a>b){
			min = b;
		}else{
			min = a;
		}
		
		for(int i=1;i<=min;i++){
			if(a%i==0 && b%i==0){
				value = i;
			}
		}
		return value;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			Stack<Integer>stack = new Stack<Integer>();
			int sum=0;
			int n = in.nextInt();
			if(n<3){
				
			}
			for(int i=2;i<n;i++){
				int tmp = n;
				while(tmp!=0){
					sum+=tmp%i;
					tmp/=i;
				}
			}
			int value = maxDivide(sum, n-2);
			
			System.out.println(sum/value+"/"+(n-2)/value);
		}
	}
}
