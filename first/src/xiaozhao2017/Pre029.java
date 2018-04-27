package xiaozhao2017;

import java.util.Scanner;
import java.lang.Math;
public class Pre029 {
	
	/*
	 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
	 * */
	
	/*
	 * 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,
	 * 每个整数都在32位int范围内。以空格分隔。
	 * */
	
	/*
	 * 所有连续子数组中和最大的值。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<a.length;i++){
			a[i] = in.nextInt();
		}
		int max = a[0];
		int count = a[0];
		for(int i=1;i<a.length;i++){
			if(count<0){
				count = a[i];
			}else{
				count+=a[i];
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
