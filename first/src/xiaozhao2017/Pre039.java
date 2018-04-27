package xiaozhao2017;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Pre039 {
	
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		while(in.hasNext()){
//			String s = in.nextLine();
//			String t = in.nextLine();
//			String[] ss = s.split(" ");
//			StringBuilder sb = new StringBuilder();
//			for(int i=0;i<ss.length;i++){
//				TreeSet<Character> treeSet = new TreeSet<>();
//				int start = 0;
//				for(int j=0;j<t.length();j++){
//					treeSet.add(t.charAt(j));
//					start = treeSet.size()-1;
//				}
//				for(int j=0;j<ss[i].length();j++){
//					treeSet.add(ss[i].charAt(j));
//				}
//				Iterator<Character> it = treeSet.iterator();
//				while(start-->=0){
//					it.next();
//				}
//				while(it.hasNext()){
//					sb.append(it.next());
//				}
//				sb.append(" ");
//			}
//			sb.deleteCharAt(sb.length()-1);
//			System.out.println(sb.toString());
//			
//		}
//	}
	
	/*
	 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”
	 * 和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
	 * */
	
	/*
	 * 每个测试输入包含2个字符串
	 * */
	
	/*
	 * 输出删除后的字符串
	 * */
	
	/*
	 * 分析：在处理字符串的时候，多多想到用正则表达式
	 * */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.nextLine();
			String  t = in.nextLine();
			String pattern = "["+t+"]";
			String res = s.replaceAll(pattern, "");
			System.out.print(res);
		}
	}
}
