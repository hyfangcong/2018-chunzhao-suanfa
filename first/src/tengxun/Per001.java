package tengxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Per001 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = in.nextInt();
			}
			
			Arrays.sort(a);
			//如果所有的数字都相同
			if(a[0]==a[n-1]){
				int minNum = n*(n-1)/2;
				System.out.println(n);
				System.out.println(minNum+" " +minNum);
				continue;
			}
			
		
			Map<Integer, Integer>map = new TreeMap<Integer,Integer>();
			for(int i=0;i<a.length;i++){
				if(map.containsKey(a[i])){
					map.put(a[i], map.get(a[i])+1);
				}else{
					map.put(a[i], 1);
				}
			}
			
			//求最小值对数
			int minNum = 1;
			if(map.size()==n){
				int min = a[1] - a[0];
				for(int i=2;i<n;i++){
					int tmp = Math.abs(a[i] - a[i-1]);
					if(tmp==min){
						minNum++;
					}else if(tmp<min){
						min = tmp;
						minNum = 1;
					}
				}
			}else{
				minNum = 0;
				for(Integer key:map.keySet()){
					int val = map.get(key);
					if(val>1){
						minNum+=val*(val-1)/2;
					}
				}
			}
			
			//求最大值对的数量
			int maxNum = 0;
			List<Integer> keyset =new ArrayList<Integer>(map.keySet());
			int val1 = map.get(keyset.get(0));
			int val2 = map.get(keyset.get(keyset.size()-1));
			maxNum = val1*val2;
			
			System.out.println(minNum+" "+maxNum);
		}
	}
}
