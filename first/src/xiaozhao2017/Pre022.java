package xiaozhao2017;

import java.util.Scanner;

public class Pre022 {
	
	/*
	 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点
	 * 是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
例如：半径的平方如果为25
优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = (int)Math.sqrt(n);
		int left=0,right=r;
		int count = 0;
		while(left<=right){
			if(left*left+right*right==n){
				if(left==0 || left==right){
					count+=4;
				}else{
					count+=8;
				}
				left++;
				right--;
			}
			else if(left*left+right*right>n){
				right--;
			}else{
				left++;
			}
		}
		System.out.println(count);
	}
}
