package xiecheng;

import java.util.Scanner;

public class Test2 {
	/*
	 * 对于传进来的参数，有可能在不同的方法块中用到的时候：
	 * 分析它们使用参数是否有前后的逻辑关系，如果有就在它们的方法外面定义变量来接收这些参数。
	 * 如果没有，它们是并列的，就在各自的方法中定义变量来接收这些参数。
	 * */
	
	//打印矩阵的一圈
	public static void printOneCicle(int[][] a,int leftTopx,int leftTopy,int rightBottomx,int rightBottomy){
		//子矩阵只有一列时
		if(leftTopy == rightBottomy){
			for(int i=leftTopx;i<=rightBottomx;i++){
				System.out.print(a[i][leftTopy]);
			}
		}
		//子矩阵只有一行时
		else if(leftTopx==rightBottomx){
			for(int j=leftTopy;j<=rightBottomy;j++){
				System.out.print(a[leftTopx][j]);
			}
		}else{
			int curx = leftTopx;
			int cury = leftTopy;
			while(cury!=rightBottomy){
				System.out.print(a[curx][cury]);
				cury++;
			}
			
			while(curx!=rightBottomx){
				System.out.print(a[curx][cury]);
				curx++;
			}
			while(cury!=leftTopy){
				System.out.print(a[curx][cury]);
				cury--;
			}
			while(curx!=leftTopx){
				System.out.print(a[curx][cury]);
				curx--;
			}

		}
	}
	
	//逆时针打印整个矩阵
	public static void clockwisePrint(int[][] a,int width,int hight){
		int leftTopx = 0,leftTopy = 0,rightBottomx = width-1, rightBottomy = hight-1;
		
		while(leftTopx<=rightBottomx && leftTopy<=rightBottomy){
			printOneCicle(a, leftTopx++, leftTopy++, rightBottomx--, rightBottomy--);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] ss = s.split(" ");
		int n = ss.length;
		//System.out.println(ss.length);
		int[][] a = new int[n][n];
		String[] input = new String[n];
		input[0] = s;
		for(int i=1;i<n;i++){
			input[i] = in.nextLine();
		}
		
		
		for(int i=0;i<n;i++){
			String[] cs = input[i].split(" ");
			for(int j=0;j<n;j++){
				a[i][j] = Integer.parseInt(cs[j]);
			}
		}
		clockwisePrint(a,n,n);
		
	}
}

