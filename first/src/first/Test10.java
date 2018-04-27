package first;

public class Test10 {
	
	/*按数组的形式给出函数f（x）的取值，数组a[0]元素为f（0）的值，函数值都为整数，并且严格单调，
	 * a[i-1]!=a[i]!=[i+1].要求求出最宽的先上升后下降的的区间
	 * 1.如果找到符合条件的最大区间输出数组对应的左右下表（如果有多个输出最左边的一个）
	 * 2.如果没有找到就输出-1-1
	 * */
	public static void maxWidthPeak(int[] a){
		int len = a.length-1;
		int tmp=len,left=len,right=len;
		int max = 0;
		int count = 0;
		
		for(int i=a.length-2;i>0;i--){
			if(tmp!=len){
				count++;
			}
			if(a[i]<a[i+1] && a[i]<a[i-1]){
				if(count>0){
					if(count>=max){
						right = tmp;
						left = i;
						tmp = i;
					}else{
						tmp = i;
					}
				}else{
					tmp = i;
				}
			}
		}
		if(left!=len){
			System.out.printf("%2s %2s",left,right);
		}else{
			System.out.printf("%2s %2s",-1,-1);
		}
		
	}
	
	public static void main(String[] args){
		int[] testcase_1 = new int[]{1,3,1,2,5,4,3,1,9,10};
		maxWidthPeak(testcase_1);
	}
}
