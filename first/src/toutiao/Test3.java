package toutiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/*
 * 有两个集合，现在从一个一个集合中拿出一个元素放到另一个集合中
 * 使这两个集合的平均值都增加
 * 集合中没有重复的元素。
 * 要求这样的操作最多*/

/*分析：
 * 从均值大的集合中取元素放到均值小的集合中
 * 
 * 取出的元素要满足3个条件：
 * 1.x要大于均值小的集合的均值
 * 2.x要小于均值大的集合的均值
 * 3.x的值不能和较小的集合的均值中的元素重复
 * 
 * 要使这样的操作最多
 * 从均值大的集合中的最小的元素开始取，这样可以使较小均值的集合的均值上升的慢，较大均值的集合的均值上升的快
 * 
 * 
 * 注意：不会出现最后较小的均值的集合的均值  大于   较大均值的集合的均值。可以用数学的方式证明。
 * */
public class Test3 {
	
	//从均值大的集合中取出元素放到均值小的集合中
	public static int maxToMin(Set<Integer>set,List<Integer>list,int sum1,int sum2){
		int count = 0;
		double size1 = set.size();				//注意这里要用double，不能用int，因为这里要比较小数部分
		double size2 = list.size();
		boolean flag = true;
		while((sum2/size2-sum1/size1)>0){
			int i;
			flag = true;
			for( i=0;i<size2;i++){
				if(list.get(i)>sum1/size1 && list.get(i)<sum2/size2 && !set.contains(list.get(i))){
					int tmp = list.remove(i);
					set.add(tmp);
					++count;
					sum1+=tmp;
					sum2-=tmp;
					size1++;
					size2--;
					flag = false;
					break;
			}
		}
			if(flag){
				return count;
			}
	}
	
		return count;
	}
	
	public static void main(String[] args){
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int [] a = new int []{1,2,5};
		int [] b = new int[]{2,3,4,5,6,19};
		int sum1=0,sum2=0;
		
		for(int i=0;i<a.length;i++){
			set.add(a[i]);
			sum1+=a[i];
		}	
		for(int i=0;i<b.length;i++){
			list.add(b[i]);
			sum2+=b[i];
		}
		
		System.out.println(maxToMin(set, list, sum1, sum2));
	}
}
