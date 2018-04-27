package xiaozhao2017;

import java.util.Arrays;
import java.util.Scanner;

public class Pre018 {
	
	/*
	 * 小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字
	 * 出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是
	 * 你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，
	 * 那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数。
	 * 
	 * 输入描述：
	 * 输入第一行为数字个数n (n ≤ 20)
	 * 第二行为n个数xi (1 ≤ xi ≤ 100000)
	 * 
	 * 输出描述：
	 * 输出最小不能由n个数选取求和组成的数
	 * */
	
	/*
	 * 分析：
	 * 呃，这个题不知道见过几次了，自从google出过一次之后，之后忘了哪里又出了这个弱化版本，现在网易
	 * 再出一次弱化版本，一点意思都没了……
	 * Google提供的官方题解在：http://code.google.com/codejam/contest/4244486/dashboard#s=a&a=2
	 * 中文简单转述：
	 * 从小到大排序，一开始一块钱都凑不出来
	 * 下面，为了0~x都有，我需要来一个1元的（不然1元凑不出来）
	 * 给了你1元的，下面必须给1+1元以内的，不然2元凑不出来
	 * 如果再给一个1元的，那你现在能凑出0~2元的，接下来+1+2或者+3，都能增大范围而且不会导致中间缺一个数（4元的不行，因为凑不出3了）
	 * ——反正一直往下，直到出现第一个算不出来的值为止。
	 * 
	 * */
	
	/*
	 * 注意：
	 * ——同学们啊，请一定要做Google出的题目，codejam可能要求高一点（这题是codejam round1的C题），但是至少
	 * APAC Test要做一做——你看google前一年出了一个01字典树，微软第二年校招实习笔试也出了一个，现在再
	 * 加上网易又来一出——简直是校招笔试编程题风向标。
	 * */
	
		public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int miss = 0;
		for(int i=0;i<n;i++){
			if(a[i]>miss+1)
				break;
			else{
				miss+=a[i];
			}
		}
		System.out.println(miss+1);
	}
}
