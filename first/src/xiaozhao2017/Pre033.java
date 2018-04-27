package xiaozhao2017;

import java.util.Scanner;
import java.util.Stack;

public class Pre033 {
	
	/*
	 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
	 * */
	
	/*
	 * 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
	 * */
	
	/*
	 * 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制
	 * （比如，10用A表示，等等）
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			Stack<Character> stack = new Stack<>();
			int m = in.nextInt();
			int n = in.nextInt();
			boolean flag = false;
			if(m<0){
				flag = true;
				m=Math.abs(m);
			}
			while(m!=0){
				if(m%n<=9){
					stack.push((char)((m%n)+'0'));
				}else{
					switch (m%n) {
					case 10:
						stack.push('A');
						break;
					case 11:
						stack.push('B');
						break;
					case 12:
						stack.push('C');
						break;
					case 13:
						stack.push('D');
						break;
					case 14:
						stack.push('E');
						break;
					case 15:
						stack.push('F');
						break;

					default:
						break;
					}
				}
				m/=n;
			}
			if(!flag){
				while(!stack.isEmpty()){
					System.out.print(stack.pop());
				}
			}else{
				System.out.print('-');
				while(!stack.isEmpty()){
					System.out.print(stack.pop());
				}
			}
		}
	}
}
