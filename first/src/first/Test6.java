package first;

public class Test6 {
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
				System.out.print(a[i][leftTopy]+":");
			}
		}
		//子矩阵只有一行时
		else if(leftTopx==rightBottomx){
			for(int j=leftTopy;j<=rightBottomy;j++){
				System.out.print(a[leftTopx][j]+":");
			}
		}else{
			int curx = leftTopx;
			int cury = leftTopy;
			while(cury!=rightBottomy){
				System.out.print(a[curx][cury]+":");
				cury++;
			}
			
			while(curx!=rightBottomx){
				System.out.print(a[curx][cury]+":");
				curx++;
			}
			while(cury!=leftTopy){
				System.out.print(a[curx][cury]+":");
				cury--;
			}
			while(curx!=leftTopx){
				System.out.print(a[curx][cury]+":");
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
		int[][] testcase_1 = new int[][]{{1}};
		int[][] testcase_2 = new int[][]{{1,2,3,4}};
		int[][] testcase_3 = new int[][]{{1},{2},{3},{4}};
		int[][] testcase_4 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] testcase_5 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] testcase_6 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		int row = 1;
		int colunm = 1;
		System.out.println("testcase_1:");
		clockwisePrint(testcase_1,1,1);
		System.out.println();
		System.out.println("testcase_2:");
		clockwisePrint(testcase_2,1,4);
		System.out.println();
		System.out.println("testcase_3:");
		clockwisePrint(testcase_3,4,1);
		System.out.println();
		System.out.println("testcase_4:");
		clockwisePrint(testcase_4,3,4);
		System.out.println();
		System.out.println("testcase_5:");
		clockwisePrint(testcase_5,4,4);
		System.out.println();
		System.out.println("testcase_6:");
		clockwisePrint(testcase_6,5,4);
		
	}
}
