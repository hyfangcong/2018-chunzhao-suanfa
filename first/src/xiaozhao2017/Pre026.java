package xiaozhao2017;

import java.util.Scanner;

public class Pre026 {
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		long res = 0;
//		for(int i=1;i<=n;i++){
//			
//			int tmp = i;
//			while(tmp%2==0){
//				tmp/=2;
//			}
//			res+=tmp;
//		}
//		System.out.println(res);
//	}
	
	
	/*
	 * 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)
	 * 为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
例如： N = 7 
f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
	 * */
	
	/*
	 * 输入一个整数N (1 ≤ N ≤ 1000000000)
	 * 
	 * */
	
	/*
	 * 输出一个整数，即为f(1) + f(2) + f(3).......f(N)
	 * */
	
	/*
	 * 分析：总体思路：
因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
 
比如1 2 3 4 5 6 7 8 9 10
即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后n/2
得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
依次类推
 
细节问题：
当n为偶数，就有n/2个奇数，根据等差数列求和公式 即(（首项+末项）*项数)/2,我们知道n/2个奇数和为((1+n-1)*n/2)/2,
即为(n/2) * (n/2),此时n为偶数，因此 (n/2) * (n/2) = ((n+1)/2)  *  ((n+1)/2)
 
当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)  *  ((n+1)/2)
因此两种情况可以用一个等式来总结
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long res = 0;
		for(int i=n;i>0;i/=2){
			long tmp = (i+1)/2;
			res+=tmp*tmp;
		}
		System.out.println(res);
		
	}
}
