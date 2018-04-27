package toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/*给定一个数m，n
 * m为要输入数据的个数
 * n为两个数据之间的差值
 *现在输出m个数据之间的差值等于n的个数，重复的只算一次
 * */

/*分析：时间复杂度为nlogn
 * 先用排序将数组排成有序的，用java自带的排序算法，时间复杂度为nlogn（默认为快排）
 * 用一个下标指向数组，然后在每个里面用二分查找算法，因此这一部分的时间复杂度也为nlogn
 * 因此总体的时间复杂度为nlogn
 * 
 * 用集合set中元素不可以重复这个性质，用来取出重复的数对*/
public class Test1 {
	
	public static int findK(ArrayList<Integer> a,int k){
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		ArrayList<Integer> list = a;
		Collections.sort(list);
	
		for(int i=0;i<list.size()-1;i++){
			binarySearch(i, k, list,set);
		}
		count = set.size();
		return count;
	}
	
	public static void  binarySearch(int index,int k,ArrayList<Integer> list,Set<Integer> set){
		int len = list.size()-1;
		int start = index+1;
		int end = len;
		int tag = list.get(index);
		
		while(start<=end){
			int mid = (end-start)/2 + start;
			if(Math.abs(tag-list.get(mid))>Math.abs(k)){
				end = mid -1;
			}else if(Math.abs(tag-list.get(mid))<Math.abs(k)){
				start = mid+1;
			}else{
				set.add(tag);
				return;
			}
		}	
		return ;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{1,5,3,4,2,3,3,5};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			list.add(a[i]);
		}
		int result = findK(list, 0);
		System.out.println(result);
		
	}
}
