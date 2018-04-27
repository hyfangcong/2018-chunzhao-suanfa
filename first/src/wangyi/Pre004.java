package wangyi;
import java.util.Scanner;

public class Pre004 {
	/*
	 * 网易2018校园招聘编程题真题集合
	 * 
	 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。牛博士给小易出了一个难题:
	对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
	小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
	 * */
	
	
	/*
	 * 分析：
	 * 任意数和4的倍数相乘，其结果任然是4的倍数。
	 * 两个是2的倍数的数相乘，其结果也是4的倍数。
	 * 
	 * 显然，这个排列可以分为以下两种情况
	 * 
	 * 1.数列中有2的倍数的数，则将2的倍数的数排在一起，然后用一个4的倍数的数连接起来，
	 * 则countMod4>=countOdd
	 * 
	 * 2.数列中没有2的倍数的数，则将之前放2的倍数的地方可以放一个奇数。因此：countMod4>=countOdd-1
	 * */
	
	public static void main(String[] args){
		int n4=0,n2=0,n1=0;
		Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			for(int i=0;i<t;i++){
				int n = in.nextInt();
				n4=0;n2=0;n1=0;
				for(int j=0;j<n;j++){
					int k = in.nextInt();
					if(k%4==0){
						n4++;
					}else if(k%2==0){
						n2++;
					}else{
						n1++;
					}
				}
				
				if(n2>0){
					if(n4>=n1){
						System.out.println("Yes");
					}else{
						System.out.println("No");
					}
				}else{
					if(n4>=n1-1){
						System.out.println("Yes");
					}else {
						System.out.println("No");
					}
				}
			}
			
			in.close();
	}
}
