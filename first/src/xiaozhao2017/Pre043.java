
package xiaozhao2017;

import java.util.ArrayList;
import java.util.Scanner;

public class Pre043 {
	
	/*
	 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
	 * */
	
	/*
	 * 输入包括一个整数n,(3 ≤ n < 1000)
	 * */
	/*
	 * 输出对数
	 * */
	public static boolean isPrime(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		for(int i=3;i<=n;i++){
			if(isPrime(i)){
				arrayList.add(i);
			}
		}
		int low = 0;
		int hi = arrayList.size()-1;
		int res = 0;
		while(low<=hi){
			if(arrayList.get(low)+arrayList.get(hi)>n){
				hi--;
			}else if(arrayList.get(low)+arrayList.get(hi)<n){
				low++;
			}else{
				res++;
				low++;
				hi--;
			}
		}
		System.out.println(res);
	}
}
