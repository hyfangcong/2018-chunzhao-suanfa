package tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pre005 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int tag = in.nextInt();
		
		int left = -90,right=90;
		int [] a = new int [6];
		for(int i=0;i<6;i++){
			int mid = (left+right)/2;
			if(tag>=mid){
				left=mid;
				a[i] = 1;
			}else{
				right=mid;
				a[i]=0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<6;i++){
			sb.append(a[i]);
		}
		System.out.println(sb.toString());
		
	}
}
