package tengxun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pre007 {

	
/*春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了
 * * 红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
若没有金额超过总数的一半，返回0。
测试样例：

[1,2,3,2,2],5
返回：2
*/

	public static void main(String[] args){
		int a[]= new int []{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		System.out.println(getgift(a,a.length));
		
	}
	
	public static int getgift(int []a,int n){
		int result = 0;
		
		Map<Integer, Integer>map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i])+1);
			}else{
				map.put(a[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer>entry:map.entrySet()){
			if(entry.getValue()>=(n/2)){
				return entry.getKey();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
