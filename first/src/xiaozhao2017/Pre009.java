package xiaozhao2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pre009 {
	
	
	/*
	 * 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示
	 * 不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能
	 * 供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)
	 * 这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，
	 * 你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
	 * 
	 *输入描述：
	 *第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，
	 *表示需要的各种颜料.
	 *
	 *输出描述：
	 *输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。

	 * */
	
	
	public static int hightBit(int a){
		int val=0;
		while(a!=0){
			a=a>>1;
			val++;
		}
		return val;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int res=0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(in.nextInt());
		}
		Collections.sort(list);
		int last = list.size()-1;
		int last_2 = last-1;
		while(last_2>0 && list.get(last_2)!=0){
			if(hightBit(list.get(last))==hightBit(list.get(last_2))){
				int tmp = list.get(last)^list.get(last_2);
				list.remove(last_2);
				if(!list.contains(tmp)){
					list.add(tmp);
				}
				Collections.sort(list);
				
			}else{
				list.remove(last);      //如果没有和最高位相同的数字就直接删掉
				res++;
			}
		}
		System.out.println(res+2);
	}
}
