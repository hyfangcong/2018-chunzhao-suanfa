package xiaozhao2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pre036 {
	
	public static void main(String[] args){
		
		/*
		 * 找出n个数里最小的k个
		 * */
		
		/*
		 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n不超过100。
		 * */
		
		/*
		 * 输出n个整数里最小的k个数。升序输出
		 * */
		
		Scanner in = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		String string = in.nextLine();
		String[] ss = string.split(" ");
		int k = Integer.parseInt(ss[ss.length-1]);
		for(int i=0;i<ss.length-1;i++){
			list.add(Integer.parseInt(ss[i]));
		}
		list.remove(list.size()-1);
		Collections.sort(list);
		for(int i=0;i<k;i++){
			if(i==k-1){
				System.out.print(list.get(i));
			}else{
				System.out.print(list.get(i)+" ");
			}
		}
	}
}
