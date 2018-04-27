package xiaozhao2017;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Pre051 {
	static long res = 0;
	static HashSet<LinkedList<Integer>> hashSet = new HashSet<>();
	static LinkedList<Integer> list = new LinkedList<>();
	public static void solve(int cur,int m,int count){
		
		if(cur == m){
			LinkedList<Integer> tmp = new LinkedList<>(list);
			Collections.sort(tmp);
			if(!hashSet.contains(tmp)){
				res++;
				hashSet.add(tmp);
			}
		}
		if(cur+1<=m){
			solve(cur+1, m, ++count);
			list.add(1);
		}
		
		if(cur+5<=m){
			solve(cur+5, m, ++count);
			list.add(5);
		}
		
		if(cur+10<=m){
			solve(cur+10, m, ++count);
			list.add(10);
		}
		
		if(cur+20<=m){
			solve(cur+20, m, ++count);
			list.add(20);
		}
		
		if(cur+50<=m){
			solve(cur+50, m, ++count);
			list.add(50);
		}
		
		if(cur+100<=m){
			solve(cur+100, m, ++count);
			list.add(100);
		}
		if(!list.isEmpty()){
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		solve(0, n, 0);
		System.out.println(res);
	}
}
