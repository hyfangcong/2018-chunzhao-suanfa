package zijietiaodong;

import java.util.Scanner;

public class Test005 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int count = 0;
			if(c==a || c==b){
				System.out.println(1);
				continue;
			}
			int r1 = b % a;
			int r2 = a - r1;
			while(r1<b && r2<b){
				if(c==r1 || r2==c){
					break;
				}else{
					r1+=a;
					r2+=a;
					count++;
				}
			}
			
			int tmp = b/a+1;
			if(c==r1){
				System.out.println(tmp*2+count*2-1);
			}else if(c==r2){
				System.out.println(tmp*2+count*2);
			}else{
				System.out.println(0);
			}
			
			
		}
	}
}
