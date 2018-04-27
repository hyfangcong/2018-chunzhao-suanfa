package first;

public class Test9 {
	
	//斜着打印一条斜线
	public static void zizhiPringLine(int[][] a,int leftx,int lefty,int rightx,int righty,boolean isFormBottom){
		if(isFormBottom){
			while(lefty<=righty){
				System.out.printf("%4s",a[leftx--][lefty++]);
			}
		}else{
			while(rightx<=leftx){
				System.out.printf("%4s",a[rightx++][righty--]);
			}
		}
	}
	
	//之字型打印矩阵
	/*左边的起始位置从矩阵的左上角开始竖着向下在横着向右到达矩阵的右下角。
	 *右边的起始位置从矩阵的左上角开始横着向右再竖着向下到达矩阵的右下角。
	 *打印结束 
	 * */
	public static void zizhiPaintMatrix(int[][] a,int row,int colunm){
		int leftx=0,lefty=0,rightx=0,righty=0;
		int endx=row-1,endy=colunm-1;
		boolean isFromBottom = true;
		
		while(lefty<=endy && rightx<=endx){
			zizhiPringLine(a, leftx, lefty, rightx, righty, isFromBottom);
			if(++leftx>endx){
				leftx=endx;
				lefty++;
			}
			if(++righty>endy){
				righty=endy;
				rightx++;
			}
			isFromBottom = !isFromBottom;
		}
	}
	
	public static void main(String[] args){
		int[][] testcase_1 = new int[][]{{1}};
		int[][] testcase_2 = new int[][]{{1,2,3,4}};
		int[][] testcase_3 = new int[][]{{1},{2},{3},{4}};
		int[][] testcase_4 = new int[][]{{1,2,3,4},{5,6,7,8}};
		int[][] testcase_5 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] testcase_6 =new int[][]{{1,2,3,4,},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		
		System.out.println("testcase_1:");
		zizhiPaintMatrix(testcase_1, 1, 1);
		System.out.println();
		
		System.out.println("testcase_2:");
		zizhiPaintMatrix(testcase_2, 1, 4);
		System.out.println();
		
		System.out.println("testcase_3:");
		zizhiPaintMatrix(testcase_3, 4, 1);
		System.out.println();
		
		System.out.println("testcase_4:");
		zizhiPaintMatrix(testcase_4, 2, 4);
		System.out.println();
		
		System.out.println("testcase_5:");
		zizhiPaintMatrix(testcase_5, 4, 4);
		System.out.println();
		
		System.out.println("testcase_6:");
		zizhiPaintMatrix(testcase_6, 5, 4);
		
	}
}
