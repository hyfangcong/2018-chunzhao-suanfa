package xiaozhao2017;

import java.util.Scanner;

public class Pre021 {
	
	public static boolean isHuiWen(int[]a,int left,int right){
		while(left<=right){
			if(a[left]!=a[right]){
				return false;
			}else{
				left++;
				right--;
			}
		}
		return true;
	}
	
	/*
	 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
现在给出一个数字序列，允许使用一种转换操作：
选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
		}
		int left=0,right=n-1;
		int count = 0;
		while(left<right){
			if(a[left]>a[right]){
				a[right-1] = a[right-1] + a[right];
				right--;
				count++;
			}else if(a[left]<a[right]){
				a[left+1] = a[left+1] + a[left];
				left++;
				count++;
			}else {
//				if(isHuiWen(a, left, right)){        不用在这时判断是否为回文
//					System.out.println(count);		一直做到最后总会得到回文的，这时候在输出操作的次数
//					
//					return;
				{
					left++;
					right--;
				}
			}
		}
		System.out.println(count);
	}
}
