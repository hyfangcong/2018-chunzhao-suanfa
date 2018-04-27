package xiaozhao2017;

import java.util.Arrays;
import java.util.Scanner;

public class Pre010 {
	/*
	 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当
	 * 所有球的号码的和大于所有球的号码的积。
	 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
	 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。
	 * 现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
	 * 
	 * 输入描述：
	 * 第一行输入一个正整数n(n ≤ 1000)
	 * 第二行为n个数正整数xi(xi ≤ 1000)
	 * 
	 * 输出描述：
	 * 输出可以产生的幸运的袋子数
	 * */
	
	public static int DFS(int[] arr,int pos,int sum,int mutl){
		int c=0;
		for(int i=pos;i<arr.length;i++){
			sum+=arr[i];
			mutl*=arr[i];
			if(sum>mutl){
				c+=1+DFS(arr, i+1, sum, mutl);
			}else if(arr[i]==1){
				c+=DFS(arr, i+1, sum, mutl);
			}else {
				break;
			}
			sum-=arr[i];
			mutl/=arr[i];
			//去重
			while(i<arr.length-1 && arr[i]==arr[i+1]){
				i++;
			}
			
		}
		return c;
		
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(DFS(arr, 0, 0, 1));
	}
}
