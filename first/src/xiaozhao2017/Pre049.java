package xiaozhao2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Pre049 {
	
	/*
	 * 现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素
	 * ，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接
	 * 为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的
	 * 余数为2。
	 * 
	 * */
	
	/*
	 * 输入数据为一行，包含9997个数字，空格隔开。
	 * */
	
	/*
	 * 输出为一行，包含一个数字。
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		HashSet<Integer> hashSet = new HashSet<>();
		for(int i=0;i<9997;i++){
			hashSet.add(in.nextInt());
		}
		
		int[] res = new int[3];
		int k = 0;
		for(int i=1;i<=10000;i++){
			if(!hashSet.contains(i)){
				res[k++] = i;
			}
		}
		Arrays.sort(res);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<res.length;i++){
			sb.append(res[i]);
		}
		System.out.println(Long.parseLong(sb.toString())%7);
	}
}
