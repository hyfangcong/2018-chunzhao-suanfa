package xiaozhao2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Pre023 {
	
	/*
	 * 此方法求约数的时间复杂度太大，可以进一步优化
	 * */
//	public static List<Integer> findFactorys(int n){
//		List<Integer>list = new ArrayList<>();
//		for(int i=2;i<=n/2;i++){
//			if(n%i==0){
//				list.add(i);
//			}
//		}
//		return list;
//	}
	
	
	/*
	 * 此方法求约数的时间复杂度低，因为利用一次可以求出一个大的和一个小的两个约数，
	 * 所以可以省去很多不必要的循环。
	 * */
	public static List<Integer>  allFactor(int n){//获得n的所有因子 除1 n外
        ArrayList list=new ArrayList();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                list.add(i);
                if(i!=n/i)list.add(n/i);
            }
        }
        return list;
    }
	
	/*
	 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数
(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好
为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板

分析：用一个数组dp来记录从n到i的所需的最少的步数。

用一个队列来维护所到达的位置，要根据这个位置来求它下一步能到达的位置。
保证出队的时候，每个位置都是从起始位置到此位置时，dp记录的是最小的步数。

这里恰好用dp的数组的下标代表位置，就满足上面的条件，所以这个队列可以省掉。
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int dp[] = new int[m+1];
		for(int i=0;i<dp.length;i++){
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[n] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		while(!queue.isEmpty()){
			int tmp = queue.poll();
			if(tmp<m){
				List<Integer> list = allFactor(tmp);
				for(int i=0;i<list.size();i++){
					if(tmp+list.get(i)<=m && dp[tmp]+1<dp[tmp+list.get(i)]){
						dp[tmp+list.get(i)] = dp[tmp]+1;
						if(dp[tmp+list.get(i)] == Integer.MAX_VALUE){
							queue.add(tmp+list.get(i));
						}
					}
				}
			}
		}
		if(dp[m]==Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(dp[m]);
		}
		
	}
	
	
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		int[] dp = new int[m+1];
//		for(int i=0;i<dp.length;i++){
//			dp[i] = Integer.MAX_VALUE;
//		}
//		dp[n] = 0;
//		for(int i=n;i<=m-2;i++){
//			if(dp[i] == Integer.MAX_VALUE)
//				continue;
//			List<Integer> list = allFactor(i);
//			for(int j=0;j<list.size();j++){
//				if(i+list.get(j)<=m){
//					if(dp[i]+1<dp[i+list.get(j)]){
//						dp[i+list.get(j)] = dp[i]+1;
//					}
//				}
//			}
//		}
//		
//		if(dp[m]==Integer.MAX_VALUE){
//			System.out.println(-1);
//		}else{
//			System.out.println(dp[m]);
//		}
//	}
}
