package xiaozhao2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Pre031 {
	
	static class Point{
		private int x;
		private int y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int calulateP(Point pop,Point peek){
		if(pop.y==peek.y){
			if(pop.x-peek.x>0){
				return 0;
			}else
				return 3;
		}else{
			return 1;
		}
	}
	
	
	
	/*666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
	 * 这里要保证回溯之后，下一次不能访问该目标位置。
	 * 并且在以后的某一刻有可能访问到目标位置，所以目标位置的visit状态就矛盾了，
	 * 不能用visit来表识目标位置能否访问。
	 * 
	 * 这里最好的方法就是用递归来实现
	 * 666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
	 * */
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		int p = in.nextInt();
//		int[][] a = new int[n][m];
//		boolean[][] visit = new boolean[n][m];
//		for(int i=0;i<n;i++){
//			for(int j=0;j<m;j++){
//				a[i][j] = in.nextInt();
//			}
//		}
//		
//		Stack<Point> stack = new Stack<>();
//		List<Point> list = new ArrayList<>(); //用来存放耗费最小的体力值所经过的路径
//		int min = Integer.MAX_VALUE;
//		stack.add(new Point(0, 0));
//		while(!stack.isEmpty()){
//			Point point = stack.peek();
//			
//			//如果这个位置为出口的位置
//			if(point.x==0 && point.y==m-1){
//				if(p<min){
//					list.clear();//清除之前的记录，重新记录耗费体力值最小的路径
//					Iterator<Point> it = stack.iterator();
//					while(it.hasNext()){
//						list.add(it.next());
//					}
//				}
//				//回溯，并将
//				
//				/*
//				 * 这里要保证回溯之后，下一次不能访问该目标位置。
//				 * 并且在以后的某一刻有可能访问到目标位置，所以目标位置的visit状态就矛盾了，
//				 * 不能用visit来表识目标位置能否访问。
//				 * 
//				 * 这里最好的方法就是用递归来实现
//				 * 
//				 * */
//			}
//			//接下来对它的四个方向进行探测
//			//向上探测
//			if(point.x-1>=0 && a[point.x-1][point.y]==1 && !visit[point.x-1][point.y]){
//				if(p-3>=0){//体力能够到达下一个位置
//					stack.push(new Point(point.x-1, point.y));
//					visit[point.x-1][point.y] = true;
//					p-=3;
//				}
//			}
//			//向右探测
//			else if(point.y+1<m && a[point.x][point.y+1]==1 && !visit[point.x][point.y+1]){
//				if(p-1>=0){
//					stack.push(new Point(point.x, point.y+1));
//					visit[point.x][point.y+1] = true;
//					p--;
//				}
//			}
//			//向下探测
//			else if(point.x+1<n && a[point.x+1][point.y]==1 && !visit[point.x+1][point.y]){
//				stack.push(new Point(point.x+1, point.y));
//				visit[point.x+1][point.y] = true;
//			}
//			//向左探测
//			else if(point.y-1>=0 && a[point.x][point.y-1]==1 && !visit[point.x][point.y-1]){
//				if(p-1>=0){
//					stack.push(new Point(point.x, point.y-1));
//					visit[point.x][point.y-1] = true;
//					p--;
//				}
//			}
//			else{
//				Point pop = stack.pop();
//				Point peek = stack.peek();
//				p+=calulateP(pop, peek);
//			}
//		}
//	}
	
	
	
	/*
	 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单
	 * ,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;
	 * 1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且
	 * 保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位
	 * 距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙
	 * 将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
	 * */
	
	/*
	 * 输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔
	 * */
	
	/*
	 * 	如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,
	 * 则输出"Can not escape!"。 测试数据保证答案唯一
	 * */
	static boolean flag = false;
	static int[][] map;
	static int n,m,maxRemain=Integer.MIN_VALUE;
	static String path = "";
	static LinkedList<String> list = new LinkedList<>();
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 n = in.nextInt();
		 m = in.nextInt();
		int p = in.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				map[i][j] = in.nextInt();
			}
		}
		
		findGoodload(0,0,p);
		if(!flag){
			System.out.println("Can not escape!");
		}else{
			System.out.println(path);
		}
	}
	
	public static void findGoodload(int x,int y,int energy ){
		if(energy<0 || x<0 || x>=n || y<0 || y>=m || map[x][y]==0)
			return;
		else{
			list.offer("["+x+","+y+"]");
			map[x][y] = 0;				//标记这个位置已经被访问了
			if(x==0 && y==m-1){
				if(energy>maxRemain){
					maxRemain = energy;
					updatePath();
				}
				map[x][y] = 1;			//将出口位置设置为1，标识可以被继续访问
				list.removeLast();		//回溯
				flag = true;			//设置标记为true标识从入口到出口路径可达
				return;
			}
			findGoodload(x, y+1, energy-1);
			findGoodload(x+1, y, energy);
			findGoodload(x, y-1, energy-1);
			findGoodload(x-1, y, energy-3);
			list.removeLast();				//该位置没有下一个位置可以访问了，回溯
		}
	}
	
	public static void updatePath(){
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			sb.append(iterator.next()+",");
			
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.length()-1);
		}
		path = sb.toString();
	}
}
