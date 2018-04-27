package xiaozhao2017;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Pre014 {
	/*
	 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的
	 * 当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它
	 * 只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，
	 * 位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
	 * 
	 * 输入描述：
	 * 输入一个初始位置x_0,范围在1到1,000,000,006
	 * 
	 * 
	 * 输出描述：
	 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
	 * 
	 * */
	
	static int min = Integer.MAX_VALUE;

	public static int DFS(long x, int count) {
		if (count > 100000) {
			min = -1;
		} else if (x % 1000000007 == 0) {
			Math.min(min, count);
		} else {
			DFS(x * 4 + 3, count++);
			DFS(x * 8 + 7, count++);
		}
		return min;
	}

	static class Node {
		long x;
		int count;
		boolean isVisit;

		public Node(long x, int count) {
			this.x = x;
			this.count = count;
			this.isVisit = false;
		}
	}

	// BFS非递归
	public static int BFS(long x) {
		Queue<Node> queue = new LinkedList<Node>();
		Set<Long> set = new HashSet<>();
		Node start = new Node(x, 0);
		queue.add(start);
		set.add(x);
		while (!queue.isEmpty()) {
			Node top = queue.poll();
			if (top.x % (1e9 + 7) == 0) {
				Math.min(min, top.count);
			}
			int tmp = top.count + 1;
			if (tmp < 1e5) {
				long x1 = (top.x * 4 + 3)%(1000000007);
				long x2 = (top.x * 8 + 7)%(1000000007);
				if (!set.contains(x1)) {
					Node node1 = new Node(x1, tmp);
					queue.add(node1);
					set.add(x1);
				}
				if (!set.contains(x2)) {
					Node node2 = new Node(x2, tmp);
					queue.add(node2);
					set.add(x2);
				}
			}
		}
		System.out.println(set.size());
		Iterator<Long>iterator = set.iterator();
		for(int i=0;i<set.size();i++){
			System.out.println(iterator.next());
		}
		return min;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long x = in.nextLong();
		System.out.println(BFS(x));
	}
}
