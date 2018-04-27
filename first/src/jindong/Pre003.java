package jindong;

import java.util.Scanner;

public class Pre003 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int count=0;
			int n = in.nextInt();
			for(int i=0;i<=n;i++){
				int sum1=0;
				int sum2=0;
				int tmp1=i;
				while(tmp1!=0){
					sum1+=tmp1%10;
					tmp1/=10;
				}
				int tmp2=i;
				while(tmp2!=0){
					sum2+=tmp2%2;
					tmp2/=2;
				}
				if(sum1==sum2){
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
