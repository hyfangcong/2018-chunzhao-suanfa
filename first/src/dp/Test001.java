package dp;

/*求三角形顶部到底部的路径中数字之和最大，只需要给出最大值，不需要给出具体的路径
 * d[i][j]只能到d[i+1][j],d[i+1][j+1]
 * 三角形有n行
 * 
 * 
 * 分析：这是一个典型的动态规划的题目：
 * 要求出第一行到底部的和最大，就只需要求出第二行到底部的和最大的值即可
 * 
 * 
 * 初始条件：maxSum[i] = D[i][j]       i=n
 * 状态转移方程：maxSum[i] =max(maxSum[i],maxSum[i+1]) +D[i][j]  i!=n
 * 
 * 这里我们采用二维数组D[n][n]存放三角形，
 * 用一维数组来存放maxSum的值，也可以用二维数组中的第n行来存放
 * */
public class Test001 {
	
	
	//动态规划求三角形顶部到底部的和的最大值
	public static int maxSum(int n,int[][] a){
		int result=0;
		int[] maxSum = new int[a.length];
		
		for(int i=0;i<a.length;i++){		//初始条件，maxSum指向底部的一行
			maxSum[i] = a[a.length-1][i];
			//System.out.print(maxSum[i]+":");
		}
		
		for(int i=a.length-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				maxSum[j] = (maxSum[j]>maxSum[j+1]?maxSum[j]:maxSum[j+1])+a[i][j];
				//maxSum[j]+=a[i][j];
				//System.out.print(maxSum[j]+":"+j+":");
			}
			System.out.println();
		}
		result = maxSum[0];
		return result;
	}
	
	//斐波那契数列求和
	public static int feibo(int n){
		//int n = 20;
		int x=0,y=0;
			if(n==3){
				return 2;
			}
			if(n==1 || n==2){
				return 1;
			}
			if(n>0){
				 x = feibo(n-1);
				 y = feibo(n-2);
			//	 System.out.println(x+y);
			}
			return x+y;
		
	}
	
	//动态规划来求斐波那契数列的值
	public static void dpfeibo(int n){
		int[] a = new int[n+1];
		for(int i=0;i<=n;i++){
			a[i] = 0;
		}
		a[3]=2;a[1]=1;a[2]=1;
		for(int i=4;i<=n;i++){
			a[i] = a[i-1]+a[i-3];
		}
		System.out.println(a[n]);
	}
	
	public static void main(String[] args){
		int[][] a = new int[][]{{7},{3,8},{8,1,0},{2,7,4,4}};
		int n = 4;
		//System.out.println(maxSum(n, a));
		
		System.out.println(feibo(20));
		
		dpfeibo(20);
		
	}
	
	
	
	
	
	
	
}
