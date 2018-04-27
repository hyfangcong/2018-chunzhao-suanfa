package xiaozhao2017;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Pre030 {
	
	static class Custom implements Comparable<Custom>{
		private int people;
		private int money;
		
		public Custom(int people,int money){
			this.people = people;
			this.money = money;
		}
		
		/*
		 * 重写这个方法，可以用于调用库中的排序集合
		 * */
		public int compareTo(Custom custom){
			if(custom.money>this.money)
				return 1;
			else if(custom.money<this.money)
				return -1;
			else
				return 0;
			
		}
	}
	
	//也可以用匿名类在调用sort方法的时候来从写compare方法
	
//	 Arrays.sort(cus, new Comparator<int[]>(){
//		 
//         public int compare(int[] a, int[] b){
//
//            return b[1]-a[1];
//
//}
//         });
//	
	/*
	 * 6666666666666666666666666666666666666
	 *这里返回的是最左边的的等于people的下标
	 *66666666666666666666666666666666666666
	 * */
	public static int bs(int[] desk,int people){
		int low = 0;
		int hight = desk.length-1;
		int mid = 0;
		while(low<=hight){
			mid = (low+hight)/2;
			if(desk[mid]>=people){
				hight = mid-1;
			}else{
				low = mid+1;
			}
		}
		return low;
	}
	
	
	/*
	 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，
	 * c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
	 * */
	
	/*
	 * 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子
	 * 可容纳的最大人数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客
	 * 人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
	 * */
	
	/*
	 * 输出一个整数,表示最大的总预计消费金额
	 * */
	
	/*
	 * 分析：基本思路就是：桌子序列升序排列  ，客人按照预定花钱多少降序排序，然后贪心法从钱多的客人开始
	 * 招呼。但是这题时间复杂度卡得太紧，在遍历能容得下第i批客人的时候需要二分查找去找否则超时，
	 * 以下是我的代码。
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] desk = new int[n];
		for(int i=0;i<desk.length;i++){
			desk[i] = in.nextInt();
		}
		Arrays.sort(desk);
		PriorityQueue<Custom> queue = new PriorityQueue<>();  //按照消费额度降序排列
		for(int i=0;i<m;i++){
			int people = in.nextInt();
			int money = in.nextInt();
			if(people<=desk[n-1]){
				queue.add(new Custom(people, money));
			}
		}
		long res = 0l;
		boolean[] visit = new boolean[n];
		while(!queue.isEmpty()){
			Custom custom = queue.poll();
			int index = bs(desk, custom.people);
			while(index<n && visit[index]==true){
				index++;
			}
			if(index<n){
				res+=custom.money;
				visit[index] = true;
			}
		}
		System.out.println(res);
	}
}
