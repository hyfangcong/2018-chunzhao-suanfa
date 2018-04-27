package xiaozhao2017;

import java.util.Scanner;

public class Pre028 {
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int t1 = in.nextInt();
//		int t2 = in.nextInt();
//		int t3 = in.nextInt();
//		int t4 = in.nextInt();
//		
//		int a = (t1+t3)/2;
//		int b = a-t1;
//		int c = t4-b;
//		if(a+b==t3){
//			System.out.println(a+" "+b+" "+c);
//		}else{
//			System.out.println("No");
//		}
//	}
	
	/*
	 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道
	 * 以下的信息：
A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
	 * */
	
	/*
	 * 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
	 * */
	
	/*
	 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在
	 * 这样的整数A，B，C，则输出No
	 *  */
	
	/*
	 * 分析：3个未知数要满足四个等式。求出a，b，c的值，然后带入4个等式使之成立。
	 * 
	 * 注意：这里的a，b，c要是整数解，因为糖果只能为整数。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int y1 = in.nextInt();
		int y2 = in.nextInt();
		int y3 = in.nextInt();
		int y4 = in.nextInt();
		float a,b,c;
		a = (y1+y3)/2f;
		b = (y3-y1)/2f;
		c = (y4-y2)/2f;
		if((a-(y1+y3)/2f)!=0){
			System.out.println("No");
			return;
		}
		if((b-(y3-y1)/2f)!=0 || b!=(y2+y4)/2f){
			System.out.println("No");
			return;
		}
		if((c-(y4-y2)/2f)!=0){
			System.out.println("No");
			return;
		}
		
		System.out.println((int)a+" "+(int)b+" "+(int)c);
	}
}
