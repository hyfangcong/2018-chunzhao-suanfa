package xiaozhao2017;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pre035 {
	
	public static void main(String[] args){
		
		/*
		 * 读入一个字符串str，输出字符串str中的连续最长的数字串
		 * */
		
		/*
		 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
		 * */
		
		/*
		 * 在一行内输出str中里连续最长的数字串。
		 * */
		
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		List<Character>list = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0' && s.charAt(i)<='9'){
				count++;
			}else{
				count=0;
			}
			
			if(count>max){
				list.clear();
				for(int j=i-count+1;j<=i;j++){
					list.add(s.charAt(j));
				}
				max = count;
			}
		}
		
		Iterator<Character> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}
}
