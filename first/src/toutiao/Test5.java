package toutiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*有n个台阶，他们距离地面的高度分别为h1,h2,h3....hn
 *小明最多能跳的高度为k
 *现在小明跳m次，问小明最高能跳多高*/
public class Test5 {
	
	static class Node {
		int high;
		int count;
		boolean isVisit;
		
		public Node(int high,int count){
			this.count = count;
			this.high = high;
			this.isVisit = false;
		}
	}
	
	/*这里的板子可以重复跳，但是人到达的位置必须被标记，在相同的位置的可能性都一样。
	 * 
	 * 题目就是利用板子的位置和人最终的落地点的位置不同，来设置陷阱的。
	 * 平常我们都是遇到访问一个结点再把这个结点入到队列中，这两个就是相同的。
	 * 而这里刚好就不是。
	 * 
	 * 还有这里人往下跳是没有意义的，因为能跳到比他高的位置，在这之前肯定能够够跳到比他低的位置。
	 * 所以这种情况不用在考虑了。
	 * */
	
	
	//找到跳的最高的位置
	public static int maxHight(List<Node>list,int k,int h){
		int result = 0;
		Queue<Node>queue = new LinkedList<Node>();
		boolean[] isVisit = new boolean[10000];
		
		//初始化队列，刚开始小明在地面上，hight=0，count=0
		Node start = new Node(0, 0);
		queue.add(start);
		while(!queue.isEmpty()){
			Node top = queue.poll();
			
			//System.out.println(top.high);
			
			result = (result>top.high)?result:top.high;
			if(top.count>=k)
				break;
			
			for(int i=0;i<list.size();i++){
				Node tmp = list.get(i);
				if(tmp.high-top.high<=h && 2*tmp.high-top.high>0 && !isVisit[2*tmp.high-top.high]){	//如果这块板子可达，并且没有被访问
					Node push = new Node(2*tmp.high-top.high,top.count+1);
					tmp.isVisit = true;			//将这块板子标记为已经被访问了
					queue.add(push);
					isVisit[2*tmp.high-top.high]=true;
					System.out.println(push.high+":"+push.count);
					//break;
					/*
					 * 这里要用广搜，所以不能加上break。
					 * 因为这里要使在有限的步骤里跳的高度最高，只能在每个位置穷尽它的所有可能。
					 * 
					 * 如果这里用深搜的话，有可能选取的不是一条最优的路径，这时候操作步骤也是+1
					 * 就会使后面回溯的时候，判断循环退出的条件的时候直接退出循环，这个时候就不是最优的路径了。
					 * 
					 * 如果没有步骤的限制，这里用广搜和深搜都可以。
					 * 因为我们就是按照一定的规则来遍历整个数组，广搜和深搜最后都会遍历完整个数组的。
					 * */
				}
			}
		}
	
		return result;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{1,3,6};
		List<Node>list = new ArrayList<Node>();
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i], 0);
			list.add(node);
		}
		
		
		
		
		System.out.println(maxHight(list, 3, 3));
	}
}
