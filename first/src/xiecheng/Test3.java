package xiecheng;

public class Test3{
	
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
		
		
	}
}
