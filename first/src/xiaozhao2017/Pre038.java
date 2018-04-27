package xiaozhao2017;

import java.util.Scanner;

public class Pre038 {
	
	public static void main(String[] args){
		
		/*
		 * 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
		 * */
		
		/*
		 * 每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
		 * */
		
		/*
		 * 依次输出倒置之后的字符串,以空格分割
		 * */
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] ss = s.split(" ");
		for(int i=ss.length-1;i>=0;i--){
			if(i==0){
				System.out.print(ss[0]);
			}else{
				System.out.print(ss[i]+" ");
			}
		}
	}
}
