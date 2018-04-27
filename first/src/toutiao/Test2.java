package toutiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*操作一：
 *  m = s;
 *  s =  s+s;
 *操作二：
 *s = s + m
 *
 *初始值：s=“a” m = s；
 *
 *现在给定一个正整数n
 *求最少的操作能够使s的长度为n
 * 
 * */
public class Test2 {
	static class Node {
		int m;
		int s;
		int count;
		
		public Node(){
			this.m=0;
			this.s=0;
			this.count=0;
		}
	}
	
	public static int findMin(Node start,int n){
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			if(node.s == n){
				return node.count;
			}else if(node.s<n){
				Node node1 = new Node();
				Node node2 = new Node();
				int count = ++node.count;
				node1.m = node.s; node1.s = node.s*2; node1.count=count;
				node2.m = node.m; node2.s = node.s+node.m; node2.count=count;
				queue.add(node1);
				queue.add(node2);
			}
		}
		return -1;
		
	}

	public static void main(String[] args){
		Node start = new Node();
		//start.s=1;start.m=1;start.count=0;
		long time = System.currentTimeMillis();
		for(int i=1;i<5000;i++){
			start.s=1;start.m=1;start.count=0;
			int result = findMin(start,i);
			System.out.println(result);
		}
		//int result = findMin(start, 999);
		System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-time)/1000f+" 秒 ");
		
	}
	
	
}
