package xiaozhao2017;

import java.util.ArrayList;
import java.util.Scanner;

public class Pre040 {
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		for(int j=1;j<=m && j<=n;j++){
//			int i = j;
//			int count = j;
//			Stack<Integer> stack = new Stack<>();
//			stack.push(i);
//			while(!stack.isEmpty() && i<=n){
//				if(count<m){
//					stack.push(++i);
//					count+=i;
//				}else if(count>m){
//					count-=stack.pop();
//					if(!stack.isEmpty()){
//						count -= stack.pop();
//					}
//				}else{
//					StringBuilder sb = new StringBuilder();
//					Iterator<Integer> it = stack.iterator();
//					while(it.hasNext()){
//						sb.append(it.next()+" ");
//					}
//					sb.deleteCharAt(sb.length()-1);
//					System.out.println(sb.toString());
//					count-=stack.pop();
//					if(!stack.isEmpty()){
//						count-=stack.pop();
//					}
//				}
//			}
//		}
//	}
	
	/*
	 * 当dfs用普通的循环和栈来实现的时候，元素出栈后有可以入栈，且入栈的位置和出栈的位置有关。
	 * 这时候就可以用递归来实现，递归中可以利用操作系统的的栈来记录这些信息。
	 * 
	 * 在使用递归的时候，要在递归的外面实例化数组来记录数据。
	 * 
	 * */
	
	/*
	 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
	 * */
	
	/*
	 * 每个测试输入包含2个整数,n和m
	 * */
	
	/*
	 * 按每个组合的字典序排列输出,每行输出一种组合
	 * */
	static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void dfs(int index ,int m,int n){
		if(m==0){
			res.add(new ArrayList<>(list));
		}else if(m<0){
			return;
		}else{
			for(int i=index;i<=m && i<=n;i++){
				list.add(i);
				dfs(i+1, m-i, n);
				list.remove(list.size()-1);
			}
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		dfs(1, m, n);
		for(int i=0;i<res.size();i++){
			ArrayList<Integer> list = res.get(i);
			for(int j=0;j<list.size();j++){
				if(j==list.size()-1){
					System.out.println(list.get(j));
				}else{
					System.out.print(list.get(j)+" ");
				}
			}
		}
	}
}
