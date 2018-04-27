package first;

public class Test7 {
	
	/*
	 * 在原地旋转矩阵，矩阵只能是n*n的矩阵。
	 * 
	 * 如果矩阵是m*n，则必须新建一个n*m的矩阵才能旋转
	 * */
	
	//顺时针旋转矩阵的一圈   旋转角度=90
	public static void clockwiseRotateMatrix(int[][] a,int leftTopx,int leftTopy,int rightBottomx,int rightBottomy){
		//以左上角的元素开始旋转
		int count = rightBottomy - leftTopy;
		for(int i=0;i<count;i++){
			int tmp = a[leftTopx][leftTopy+i];
			a[leftTopx][leftTopy+i] = a[rightBottomx-i][leftTopy];
			a[rightBottomx-i][leftTopy] = a[rightBottomx][rightBottomy-i];
			a[rightBottomx][rightBottomy-i] = a[leftTopx+i][rightBottomy];
			a[leftTopx+i][rightBottomy] = tmp;
		}
	}
	
	//顺时针旋转矩阵
	public static void rotateMatrix(int[][] a, int row, int colunm){
		if(row!=colunm){
			System.out.println("矩阵的行列不相等，请重新输入！");
			return;
		}else{
			int leftTopx=0,leftTopy=0,rightBottomx=row-1,rightBottomy=colunm-1;
			while(leftTopx<rightBottomx){
				clockwiseRotateMatrix(a, leftTopx++, leftTopy++, rightBottomx--, rightBottomy--);
			}
		}
	}
	
	//打印矩阵
	public static void printMatrix(int[][] a,int row,int colunm){
		for(int i=0;i<row;i++){
			for(int j=0;j<colunm;j++){
				System.out.printf("%4s",a[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[][] testcase_1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] testcase_2 = new int[][]{{1,2},{3,4}};
		int[][] testcase_3 = new int[][]{{1}};
		int[][] testcase_4 = new int[][]{{1,2,3,4},{5,6,7,8}};
		int row_1=4, colunm_1=4;
		int row_2=2, colunm_2=2;
		int row_3=1, colunm_3=1;
		int row_4=2, colunm_4=4;
		System.out.println("tasecase_1:");
		printMatrix(testcase_1, row_1, colunm_1);
		System.out.println();
		rotateMatrix(testcase_1, row_1, colunm_1);
		printMatrix(testcase_1, row_1, colunm_1);
		
		System.out.println("tasecase_2:");
		printMatrix(testcase_2, row_2, colunm_2);
		System.out.println();
		rotateMatrix(testcase_2, row_2, colunm_2);
		printMatrix(testcase_2, row_2, colunm_2);
		
		System.out.println("tasecase_3:");
		printMatrix(testcase_3, row_3, colunm_3);
		System.out.println();
		rotateMatrix(testcase_3, row_3, colunm_3);
		printMatrix(testcase_3, row_3, colunm_3);
		
		System.out.println("tasecase_4:");
		printMatrix(testcase_4, row_4, colunm_4);
		System.out.println();
		rotateMatrix(testcase_4, row_4, colunm_4);
		printMatrix(testcase_4, row_4, colunm_4);
		
		
	}
}
