package xiaozhao2017;

import java.util.Scanner;

public class Pre041 {
	/*
	 * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个
	 * 数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx,
	 *  yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，
	 *  输出这个编码对应的Index.
	 * 
	 * */
	
	/*
	 * 输入一个待编码的字符串,字符串长度小于等于100.
	 * */
	
	/*
	 * 输出这个编码的index
	 * */
	
	/*
	 * 分析：末尾的+1就是因为'b'-'a'=1,二这里其实有2中情况a和b。
	 * */
	static final int N1 = 1;
	static final int N2 = 25;
	static final int N3 = 25*25;
	static final int N4 = 25*25*25;
	static final int C1 = N1;
	static final int C2 = N1+N2;
	static final int C3 = N1+N2+N3;
	static final int C4 = N1+N2+N3+N4;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String code = in.next();
		int res = 0;
		for(int i=0;i<code.length();i++){
			switch (i) {
			case 0:
				res+=(code.charAt(i)-'a')*C4;
				break;
			case 1:
				res+=(code.charAt(i)-'a')*C3+1;
				break;
			case 2:
				res+=(code.charAt(i)-'a')*C2+1;
				break;
			case 3:
				res+=(code.charAt(i)-'a')*C1+1;
				break;

			default:
				break;
			}
		}
		System.out.println(res);
	}
}
