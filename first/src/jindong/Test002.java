package jindong;

import java.util.Scanner;

public class Test002 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int  n = in.nextInt();
		for(int i=0;i<n;i++){
			Long x=1l,y=1l;
			Long tag = in.nextLong();
			if(tag%2!=0){
				System.out.println("No");
			}else{
				while(tag%2==0){
					tag/=2;
					y*=2;
				}
				x = tag;
				System.out.println(x+" "+y);
			}
		}
	}
}
