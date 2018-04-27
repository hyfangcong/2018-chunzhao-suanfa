package xiaozhao2017;

import java.util.Scanner;

public class Pre006 {
	
	/*
	 * 航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计
	 * ，如果在发射过程中，产生了 x 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗
	 * 超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，
	 * 那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？
	 * 
	 * */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long n = Long.parseLong(in.next());
			
			int result =(int) (Math.sqrt(1+4*n)-1)/2;
			System.out.println(result);
		}
	}
}
