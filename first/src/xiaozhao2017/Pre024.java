package xiaozhao2017;


import java.util.Scanner;
import java.lang.Math;

public class Pre024 {
	
	/*
	 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，
	 * 那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
	 * */
	/*
	 *分析：典型的动态规划的题目，根据前一个状态来推导后一个状态。
	 *
	 *如果要求属两个为n的黑暗字符串的数量，已知前n-1的黑暗字符串的数量，那么从前一个向后扩展一位，需要在ABC
	 *中选一个字母，此时要保证还是黑暗字符串，就需要考虑n-1状态下的末尾2个字符的状态，分为相同和不同两种。
	 *f(n-1) = s(n-1) + d(n-1)
	 *
	 *如果相同：那么新增字符ABC都可以，有3*s(n-1)
	 *如果不同：那么新增的字符只可能是两个中的一个，所以有2*的d(n-1)
	 *
	 *那么可以得出 f(n) = 3*s(n-1) + 2*d(n-1)
	 *f(n) = 2f(n-1) + s(n-1);
	 *
	 *现在要找出s(n-1) 和 f(n-2)的关系。
	 *因为s(n-1)的要求是数量为n-1的时候末尾的两个字母相同，所以s(n-1) = f(n-2)
	 *
	 *最后得出递推关系式：f(n) = 2*f(n-1) + f(n-2)
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		long[] num = new long[input+1];
		num[1] = 3;
		num[2] = 9;
		for(int i=3;i<=input;i++){
			num[i] = 2*num[i-1] + num[i-2];
		}
		System.out.println(num[input]);
	}
}