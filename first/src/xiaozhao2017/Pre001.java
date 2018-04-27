package xiaozhao2017;

import java.util.Scanner;

public class Pre001 {
	/*有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学
	 * 生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
	 * 
	 * 输入描述：
	 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来
	 * 的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，
	 * k 和 d (1 <= k <= 10, 1 <= d <= 50)。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int arr[] = new int[n+1];
			int dp_max[][] = new int[n+1][n+1];
			int dp_min[][] = new int[n+1][n+1];
			
			for(int i=1;i<=n;i++){
				arr[i] = in.nextInt();
			}
			
			int kk = in.nextInt();
			int dd = in.nextInt();
			
			//初始化
			for(int i=1;i<=n;i++){
				dp_max[i][1] = arr[i];
				dp_min[i][1] = arr[i];
			}
			
			for(int k=2;k<kk;k++ ){
				for(int i=k;i<=n;i++){
					long tmpmax = Integer.MIN_VALUE;
					long tmpmin = Integer.MAX_VALUE;
					for(int left=Math.max(1, i-dd);left<i;left++){
						if(tmpmax<Math.max(dp_max[left][k-1]*arr[i], dp_min[left][k-1]*arr[i])){
							tmpmax = Math.max(dp_max[left][k-1]*arr[i], dp_min[left][k-1]*arr[i]);
						}
						if(tmpmin>Math.min(dp_max[left][k-1]*arr[i], dp_min[left][k-1]*arr[i])){
							tmpmin = Math.min(dp_max[left][k-1]*arr[i], dp_min[left][k-1]*arr[i]);
						}
					}
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=kk;i<=n;i++){
				max = Math.max(max, dp_max[i][kk]);
			}
			System.out.println(max);
		}
		
	}
}
