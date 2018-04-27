package xiaozhao2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pre020 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int group = in.nextInt();
		while(group-->0){
			int n = in.nextInt();
			Queue<Integer>queue = new LinkedList<>();
			int[] res = new int[n];
			for(int i=1;i<=n;i++){
				queue.add(i);
			}
			int index = 0;
			while(!queue.isEmpty()){
				int x = queue.peek();
				queue.poll();
				queue.add(x);
				x = queue.peek();
				res[index++] = x;
				queue.poll();
			}
			for(int i=0;i<n;i++){
				if(i==0)
					System.out.print(res[i]);
				else
					System.out.print(" "+res[i]);
			}
			System.out.println();
		}
	}
}
