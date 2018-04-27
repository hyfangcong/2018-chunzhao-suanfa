package xiaozhao2017;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Pre019 {
	
	//直接暴力搜索，运行超时
	public static void wash(int[] a,int[] b,int k){
		Stack<Integer>stack = new Stack<>();
		while(k-->0){
			for(int i=a.length-1;i>=0;i--){
				stack.add(b[i]);
				stack.add(a[i]);
			}
			Iterator<Integer>it = stack.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			for(int i=0;i<a.length;i++){
				a[i] = stack.pop();
			}
			for(int i=0;i<b.length;i++){
				b[i] = stack.pop();
			}
			stack.clear();
		}
	}
	
	/*
	 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，
	 * 第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着
	 * 第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，
	 * 接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来
	 * 就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
	 * 在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，
	 * 就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
	 * 
	 * 输入描述：
	 * 第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行
	 * 有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
	 * 
	 * 输出描述：
	 * 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
	 * 
	 * 
	 * 
	 * 分析：
	 * * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
	 * 根据当前数的位置，可以算出经过一次洗牌后的位置
	 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
	 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
	 * 个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
	 * 毕竟测试用例不通过什么都没用
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int group = in.nextInt();
		while(group-->0){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[2*n];
			for(int i=0;i<2*n;i++){
				int tmp = i+1;
				for(int j=0;j<k;j++){
					if(tmp<=n)
						tmp = 2*tmp-1;
					else
						tmp = 2*(tmp-n);
				}
				a[tmp-1] = in.nextInt();
			}
			for(int i=0;i<2*n;i++){
				if(i==0){
					System.out.print(a[i]);
				}else
					System.out.print(" "+a[i]);
			}
			System.out.println();
		}
	}
}
