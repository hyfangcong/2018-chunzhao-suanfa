package wangyi;

import java.util.Scanner;

public class Pre007 {
	
	/*
	 * 小易正在玩一款新出的射击游戏,这个射击游戏在一个二维平面进行,小易在坐标原点(0,0),平面上有n只怪物,每个怪物有所在的坐标(x[i], y[i])。
	 * 小易进行一次射击会把x轴和y轴上(包含坐标原点)的怪物一次性消灭。小易是这个游戏的VIP玩家,他拥有两项特权操作:
	 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
	 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度小易要进行一次射击。小易在进行射击前,
	 * 可以使用这两项特权操作任意次。小易想知道在他射击的时候最多可以同时消灭多少只怪物,请你帮帮小易。
	 * 
	 * 
	 * 输入描述：
	 * 输入包括三行。
	 * 第一行中有一个正整数n(1 ≤ n ≤ 50),表示平面内的怪物数量。
	 * 第二行包括n个整数x[i](-1,000,000 ≤ x[i] ≤ 1,000,000),表示每只怪物所在坐标的横坐标,以空格分割。
	 * 第三行包括n个整数y[i](-1,000,000 ≤ y[i] ≤ 1,000,000),表示每只怪物所在坐标的纵坐标,以空格分割。
	 * 
	 * 输出描述：
	 * 输出一个整数表示小易最多能消灭多少只怪物。
	 * 
	 * 
	 * 分析：
	 * 四个for循环。每个for循环选取一个点（判断该点不同于前面的点），前三个点要求不共线。
	 * 前两个点A,B通过第一条直线； 第三个点C通过另一条直线；
	 * 第四个for循环，对于剩下的n-3个点，判断是否落在这两条直线上。如果有AD与AB平行，则落在第一条直线上；如果有CD与AB垂直，则落在第二条直线上。
	 * 第四个for循环结束，可以知道这两条直线能穿过最多几个点，每次更新最大值。
	 * 所有循环结束，输出最终的最大值即可。
	 * 计算斜率来判断平行和垂直，即dx1 * dy2 == dy1 *dx2。
	 * */
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i=0;i<n;i++){
			x[i] = in.nextInt();
		}
		for(int i=0;i<n;i++){
			y[i] = in.nextInt();
		}
		int maxShoot=0;
		if(n<4){
			System.out.println("n");
			in.close();
			return;
		}
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int x1 = x[j]-x[i];
				int y1 = y[j]-y[i];
				for(int k=0;k<n;k++){
					if(k==i || k==j){
						continue;
					}
					int count=3;
					for(int r=0;r<n;r++){
						if(r==i || r==j || r==k){
							continue;
						}
						int x2 = x[r]-x[i];
						int y2 = y[r]-y[i];
						int x3 = x[r]-x[k];
						int y3 = y[r]-y[k];
						if(x1*y2==x2*y1 || x1*x3+y1*y3==0){
							count++;
						}
					}
					if(count>maxShoot){
						maxShoot = count;
					}
				}
			}
		}
		System.out.println(maxShoot);
		in.close();
	}
}
