package first;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public  class Test {
	

	public static void main(String[] args) {
		System.out.println("hha");
		int [] a= new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
		int result = BinarySearch(a, 57);
		System.out.println(result);
		
	}
	
	public static void ShellSort(int[] a){
		int gap;
		int tmp;
		for(gap=a.length/2;gap>=1;gap/=2){
			System.out.println("步长："+gap);
			for(int i=gap;i<a.length;i++){
				tmp=a[i];
				int j;
				for(j=i;j>=gap&&a[j-gap]<tmp;j-=gap){
					a[j]=a[j-gap];
				}
				a[j]=tmp;
			}
			for(int k=0;k<a.length;k++){
				System.out.print(a[k]+":");
			}
			System.out.println();
		}
	}
	
	public static void quickSort(int[] a,int left,int right){
		if(left<right){
			int low=left, hight=right;
			int pivot = a[left];
			
			while(low<hight){
				while(low<hight&&a[hight]>=pivot){
					hight--;
				}
				a[low] = a[hight];
				while(low<hight&&a[low]<=pivot){
					low++;
				}
				a[hight]=a[low];
			}
			a[low] = pivot;
			quickSort(a, left,low-1 );
			quickSort(a, low+1, right);
		}
	}
	
	public static void mergeSort(int[] a,int[] b,int left,int right){
		if(left<right){
			int center = left+(right-left)/2;
			mergeSort(a, b, left, center);
			mergeSort(a, b, center+1, right);
			merge(a,b,left,center+1,right);
		}
	}
	
	public static void merge(int[] a,int[] b,int leftStart,int rightStart,int rightEnd){
		int leftEnd = rightStart-1;
		int tmpPos = leftStart;
		int numElement = rightEnd-leftStart+1;
		
		while(leftStart<=leftEnd&&rightStart<=rightEnd){
			if(a[leftStart]<a[rightStart]){
				b[tmpPos] = a[leftStart];
				tmpPos++;
				leftStart++;
			}else{
				b[tmpPos] = a[rightStart];
				tmpPos++;
				rightStart++;
			}
		}
		while(leftStart<=leftEnd){
			b[tmpPos] = a[leftStart];
			tmpPos++;
			leftStart++;
		}
		
		while(rightStart<=rightEnd){
			b[tmpPos] = a[rightStart];
			tmpPos++;
			rightStart++;
		}
		for(int i=0;i<numElement;i++,rightEnd--){
			a[rightEnd] = b[rightEnd];
		}
		
	}
	
	public static int BinarySearch(int[] a,int v){
		int mid;
		int low=0;
		int hight=a.length-1;
		
		while(low<hight){
			mid = low +(hight-low)/2;
			if(a[mid]==v){
				return v;
			}else if(a[mid]<v){
				low = mid+1;
			}else{
				hight = mid-1;
			}
		}
		return -1;
	}

}
