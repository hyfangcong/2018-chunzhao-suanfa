package tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pre004 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer>list = new ArrayList<Integer>();
		
		//求出n之间的所有质数
		list.add(2);
		for(int i=3;i<=n;i++){
			int j;
			for( j=2;j<Math.sqrt(i);j++){
				if(i%j==0){
					break;
				}
			}
			if(i==j){
				list.add(i);
			}
		}
		
		int left=0,right=list.size()-1;
		int count=0;
		while(left<=right){
			if(list.get(left)+list.get(right)==n){
				System.out.println(left+" "+right);
				count++;
				left++;
				right--;
			}else if(list.get(left)+list.get(right)<n){
				left++;
			}else {
				right--;
			}
			
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)+" ");
		}
		System.out.println(count);
		
	}
}
